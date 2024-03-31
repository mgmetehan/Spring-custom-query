package com.mgmetehan.customquery.controller;

import com.mgmetehan.customquery.dto.UserDto;
import com.mgmetehan.customquery.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/jpa/active")
    public List<UserDto> getActiveUsersJPA() {
        return userService.getActiveUsersJPA();
    }

    @GetMapping("/jpql/active")
    public List<UserDto> getActiveUsersJPQL() {
        return userService.getActiveUsersJPQL();
    }

    @GetMapping("/native/active")
    public List<UserDto> getActiveUsersNative() {
        return userService.getActiveUsersNative();
    }



}
