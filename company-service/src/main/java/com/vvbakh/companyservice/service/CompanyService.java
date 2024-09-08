package com.vvbakh.companyservice.service;

import com.vvbakh.companyservice.dto.CompanySearchFilter;
import com.vvbakh.companyservice.model.FullCompany;

public interface CompanyService {
    FullCompany findCompanyById(Long companyId);

    FullCompany searchCompany(CompanySearchFilter searchFilter);
}
