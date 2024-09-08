package com.vvbakh.userservice.service;

import com.vvbakh.userservice.model.User;
import com.vvbakh.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getUsersByIdsIn(List<Long> id) {
        final List<User> users = userRepository.findUsersByIdIn(id);
        log.info("Found users by ids, number of users '{}'.", users.size());
        return users;
    }
}
