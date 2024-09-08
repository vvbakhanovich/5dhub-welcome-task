package com.vvbakh.companyservice.repository;

import com.vvbakh.companyservice.model.Company;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

@UtilityClass
public class CompanySpecification {

    public static Specification<Company> idEquals(Long id) {
        if (id == null) {
            return null;
        }

        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    public static Specification<Company> companyNameEquals(String text) {
        if (text == null) {
            return null;
        }

        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("companyName")), text.toLowerCase());
    }
}
