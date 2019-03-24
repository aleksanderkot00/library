package com.crud.library.controller;

import com.crud.library.domain.Dto.TitleDto;
import com.crud.library.domain.Dto.UserDto;
import com.crud.library.domain.Title;
import com.crud.library.mapper.UserMapper;
import com.crud.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    UserService userService;

    @PostMapping(value = "addUser")
    public UserDto addBook(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(userService.addUser(userMapper.mapToUser(userDto)));
    }
}
