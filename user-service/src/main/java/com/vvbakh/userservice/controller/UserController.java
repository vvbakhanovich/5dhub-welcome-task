package com.vvbakh.userservice.controller;

import com.vvbakh.userservice.dto.UserDto;
import com.vvbakh.userservice.mapper.UserMapper;
import com.vvbakh.userservice.model.User;
import com.vvbakh.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public UserDto findUserByLastname(@RequestParam String lastname) {
        log.info("Requesting users with surname '{}'.", lastname);
        final User user = userService.findUserByLastname(lastname);
        return userMapper.toDto(user);
    }

    @GetMapping
    public List<UserDto> getUsersByIdsIn(@RequestParam List<Long> id) {
        log.info("Requesting users by ids, number of ids '{}'.", id.size());
        final List<User> users = userService.getUsersByIdsIn(id);
        return userMapper.toDtoList(users);
    }
}
