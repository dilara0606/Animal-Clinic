package com.AnimalClinic.specification;

import com.AnimalClinic.entity.User;
import com.AnimalClinic.filter.UserFilter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecification {
    public static Specification<User> searchUser(UserFilter userFilter) {
        return (Root< User > root, CriteriaQuery< ?> query, CriteriaBuilder builder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (userFilter.getName() != null && !userFilter.getName().isEmpty()) {
                Predicate namePredicate = builder.like(builder.lower(root.get("name")),
                        "%" + userFilter.getName().toLowerCase() + "%");
                predicates.add(namePredicate);
            }

            if (userFilter.getSurname() != null && !userFilter.getSurname().isEmpty()) {
                Predicate surnamePredicate = builder.like(builder.lower(root.get("surname")),
                        "%" + userFilter.getSurname().toLowerCase() + "%");
                predicates.add(surnamePredicate);
            }

            if (!predicates.isEmpty()) {
                return builder.or(predicates.toArray(new Predicate[0]));
            } else {
                return builder.conjunction();
            }
        };
    }
}
