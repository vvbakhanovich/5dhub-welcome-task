package com.vvbakh.companyservice.client;

import com.vvbakh.companyservice.dto.Employee;

import java.util.List;

public interface EmployeeClient {
    List<Employee> findEmploeesByIdsIn(List<Long> ids);
}
