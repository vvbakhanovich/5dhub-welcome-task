package com.vvbakh.companyservice.model;

import com.vvbakh.companyservice.dto.Employee;

import java.math.BigDecimal;
import java.util.List;

public record FullCompany(Long id,
                          String companyName,
                          BigDecimal budget,
                          List<Employee> employees) {
}
