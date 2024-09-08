package com.vvbakh.companyservice.controller;

import com.vvbakh.companyservice.dto.CompanyDto;
import com.vvbakh.companyservice.mapper.CompanyMapper;
import com.vvbakh.companyservice.model.FullCompany;
import com.vvbakh.companyservice.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/companies")
@RequiredArgsConstructor
@Slf4j
public class CompanyController {

    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    @GetMapping("/{companyId}")
    public CompanyDto findCompanyById(@PathVariable Long companyId) {
        log.debug("Requesting company with id '{}'.", companyId);
        FullCompany company = companyService.findCompanyById(companyId);
        return companyMapper.toDto(company);
    }
}
