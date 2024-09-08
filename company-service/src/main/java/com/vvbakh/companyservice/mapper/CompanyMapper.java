package com.vvbakh.companyservice.mapper;

import com.vvbakh.companyservice.dto.CompanyDto;
import com.vvbakh.companyservice.model.FullCompany;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyDto toDto(FullCompany company);
}
