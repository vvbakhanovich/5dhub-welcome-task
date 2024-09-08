package com.vvbakh.userservice.repository;

import com.vvbakh.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUsersByIdIn(List<Long> ids);

    Optional<User> findUserByLastname(String lastname);
}
