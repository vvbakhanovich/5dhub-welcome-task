package com.vvbakh.userservice.mapper;

import com.vvbakh.userservice.dto.UserDto;
import com.vvbakh.userservice.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    UserDto toDto(User user);

    List<UserDto> toDtoList(List<User> users);
}
