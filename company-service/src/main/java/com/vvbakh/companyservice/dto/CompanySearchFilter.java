package com.vvbakh.companyservice.dto;

import lombok.Builder;

@Builder
public record CompanySearchFilter(Long companyId,
                                  String companyName) {
}
