package com.vvbakh.companyservice.service;

import com.vvbakh.companyservice.client.EmployeeClient;
import com.vvbakh.companyservice.dto.CompanySearchFilter;
import com.vvbakh.companyservice.dto.Employee;
import com.vvbakh.companyservice.exception.NotFoundException;
import com.vvbakh.companyservice.model.Company;
import com.vvbakh.companyservice.model.FullCompany;
import com.vvbakh.companyservice.repository.CompanyRepository;
import com.vvbakh.companyservice.repository.CompanySpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final EmployeeClient employeeClient;

    @Override
    public FullCompany findCompanyById(Long companyId) {
        final Company company = companyRepository.findCompanyById(companyId);
        final List<Employee> employees = employeeClient.findEmployeesByIdsIn(company.getEmployees());
        FullCompany fullCompany = new FullCompany(company.getId(), company.getCompanyName(), company.getBudget(), employees);
        log.debug("Found company with id '{}'.", companyId);
        return fullCompany;
    }

    @Override
    public FullCompany searchCompany(CompanySearchFilter searchFilter) {
        final List<Specification<Company>> specifications = companySearchFilterToSpecifications(searchFilter);
        final Specification<Company> resultSpec = specifications.stream().reduce(Specification::or).orElse(null);
        Company company = companyRepository.findOne(resultSpec)
                .orElseThrow(() -> new NotFoundException("Company not found by searchFilter :: " + searchFilter));
        final List<Employee> employees = employeeClient.findEmployeesByIdsIn(company.getEmployees());
        FullCompany fullCompany = new FullCompany(company.getId(), company.getCompanyName(), company.getBudget(), employees);
        log.debug("Found company by filter '{}'.", searchFilter);
        return fullCompany;
    }

    private List<Specification<Company>> companySearchFilterToSpecifications(CompanySearchFilter searchFilter) {
        final List<Specification<Company>> resultSpecification = new ArrayList<>();
        resultSpecification.add(CompanySpecification.idEquals(searchFilter.companyId()));
        resultSpecification.add(CompanySpecification.companyNameEquals(searchFilter.companyName()));
        return resultSpecification.stream().filter(Objects::nonNull).toList();
    }
}
