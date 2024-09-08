package com.vvbakh.companyservice.repository;

import com.vvbakh.companyservice.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company, Long>, JpaSpecificationExecutor<Company> {

    @Query("SELECT c FROM Company c JOIN FETCH c.employees WHERE c.id = ?1")
    Company findCompanyById(Long companyId);
}
