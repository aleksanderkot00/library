package com.crud.library.mapper;

import com.crud.library.domain.Dto.UserDto;
import com.crud.library.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(UserDto userDto) {
        return new User(userDto.getName(),userDto.getLastName(),userDto.getAccountCreationDate());
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(user.getName(),user.getLastName(),user.getAccountCreationDate());
    }
}
