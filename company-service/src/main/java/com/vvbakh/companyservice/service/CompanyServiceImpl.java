package com.vvbakh.companyservice.service;

import com.vvbakh.companyservice.client.EmployeeClient;
import com.vvbakh.companyservice.dto.Employee;
import com.vvbakh.companyservice.model.Company;
import com.vvbakh.companyservice.model.FullCompany;
import com.vvbakh.companyservice.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
