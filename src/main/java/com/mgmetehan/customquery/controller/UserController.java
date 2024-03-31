package com.mgmetehan.customquery.controller;

import com.mgmetehan.customquery.dto.UserDto;
import com.mgmetehan.customquery.model.User;
import com.mgmetehan.customquery.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/jpa/findByUsernameAndActiveTrue")
    public List<UserDto> findByUsernameAndActiveTrueJPA(@RequestParam String username) {
        return userService.findByUsernameAndActiveTrueJPA(username);
    }

    @GetMapping("/jpql/findByUsernameAndActiveTrue")
    public List<UserDto> findByUsernameAndActiveTrueJPQL(@RequestParam String username) {
        return userService.findByUsernameAndActiveTrueJPQL(username);
    }

    @GetMapping("/native/findByUsernameAndActiveTrue")
    public List<UserDto> findByUsernameAndActiveTrueNative(@RequestParam String username) {
        return userService.findByUsernameAndActiveTrueNative(username);
    }

    @GetMapping("/jpa/findBySalaryGreaterThan/{salary}")
    public List<UserDto> findBySalaryGreaterThanJPA(@PathVariable long salary) {
        return userService.findBySalaryGreaterThanJPA(salary);
    }

    @GetMapping("/jpql/findBySalaryGreaterThan/{salary}")
    public List<UserDto> findBySalaryGreaterThanJPQL(@PathVariable long salary) {
        return userService.findBySalaryGreaterThanJPQL(salary);
    }

    @GetMapping("/native/findBySalaryGreaterThan/{salary}")
    public List<UserDto> findBySalaryGreaterThanNative(@PathVariable long salary) {
        return userService.findBySalaryGreaterThanNative(salary);
    }

    @GetMapping("/jpa/findBySalaryBetween/{minSalary}/{maxSalary}")
    public List<UserDto> findBySalaryBetweenJPA(@PathVariable long minSalary, @PathVariable long maxSalary) {
        return userService.findBySalaryBetweenJPA(minSalary, maxSalary);
    }

    @GetMapping("/jpql/findBySalaryBetween/{minSalary}/{maxSalary}")
    public List<UserDto> findBySalaryBetweenJPQL(@PathVariable long minSalary, @PathVariable long maxSalary) {
        return userService.findBySalaryBetweenJPQL(minSalary, maxSalary);
    }

    @GetMapping("/native/findBySalaryBetween/{minSalary}/{maxSalary}")
    public List<UserDto> findBySalaryBetweenNative(@PathVariable long minSalary, @PathVariable long maxSalary) {
        return userService.findBySalaryBetweenNative(minSalary, maxSalary);
    }

    @GetMapping("/jpa/countActiveUsers")
    public long countActiveUsersJPA() {
        return userService.countActiveUsersJPA();
    }

    @GetMapping("/jpql/countActiveUsers")
    public long countActiveUsersJPQL() {
        return userService.countActiveUsersJPQL();
    }

    @GetMapping("/native/countActiveUsers")
    public long countActiveUsersNative() {
        return userService.countActiveUsersNative();
    }
}
