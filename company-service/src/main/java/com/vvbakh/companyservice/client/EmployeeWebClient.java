package com.vvbakh.companyservice.client;

import com.vvbakh.companyservice.dto.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmployeeWebClient implements EmployeeClient {

    private final WebClient webClient;

    @Override
    public List<Employee> findEmployeesByIdsIn(List<Long> ids) {
        final String commaSeperatedIds = ids.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        final String uri = String.format("?id=%s", commaSeperatedIds);
        log.debug("Sending request to user service to find users in ids '{}'.", commaSeperatedIds);
        return webClient
                .get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(Employee.class)
                .collectList()
                .block();
    }
}
