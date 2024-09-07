package com.vvbakh.userservice.service;

import com.vvbakh.userservice.model.User;
import com.vvbakh.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getUsersByIdsIn(List<Long> id) {
        return userRepository.findUsersByIdIn(id);
    }
}
