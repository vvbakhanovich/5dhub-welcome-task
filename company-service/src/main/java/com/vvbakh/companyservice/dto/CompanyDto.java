package com.vvbakh.companyservice.dto;

import java.math.BigDecimal;
import java.util.List;

public record CompanyDto(Long id,
                         String companyName,
                         BigDecimal budget,
                         List<Employee> employees) {
}
