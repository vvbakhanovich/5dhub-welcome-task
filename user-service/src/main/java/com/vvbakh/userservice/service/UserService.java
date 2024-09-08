package com.vvbakh.userservice.service;

import com.vvbakh.userservice.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsersByIdsIn(List<Long> id);

    User findUserByLastname(String surname);
}
