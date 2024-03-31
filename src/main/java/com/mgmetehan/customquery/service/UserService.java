package com.mgmetehan.customquery.service;

import com.mgmetehan.customquery.dto.UserDto;
import com.mgmetehan.customquery.model.User;
import com.mgmetehan.customquery.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto createUser(UserDto userDto) {
        User user = userDto.toEntity(userDto);
        User savedUser = userRepository.save(user);
        return savedUser.toDto(savedUser);
    }

    public List<UserDto> getActiveUsersJPA() {
        List<User> activeUsers = userRepository.findByActiveTrue();
        return UserDto.toDtoList(activeUsers);
    }

    public List<UserDto> getActiveUsersJPQL() {
        List<User> activeUsers = userRepository.findActiveUsersJPQL();
        return UserDto.toDtoList(activeUsers);
    }

    public List<UserDto> getActiveUsersNative() {
        List<User> activeUsers = userRepository.findActiveUsersNative();
        return UserDto.toDtoList(activeUsers);
    }

    public List<UserDto> findByUsernameAndActiveTrueJPA(String username) {
        List<User> activeUsers = userRepository.findByUsernameAndActiveTrue(username);
        return UserDto.toDtoList(activeUsers);
    }

    public List<UserDto> findByUsernameAndActiveTrueJPQL(String username) {
        List<User> activeUsers = userRepository.findActiveUsersByUsernameJPQL(username);
        return UserDto.toDtoList(activeUsers);
    }

    public List<UserDto> findByUsernameAndActiveTrueNative(String username) {
        List<User> activeUsers = userRepository.findActiveUsersByUsernameNative(username);
        return UserDto.toDtoList(activeUsers);
    }

    public List<UserDto> findBySalaryGreaterThanJPA(long salary) {
        List<User> activeUsers = userRepository.findBySalaryGreaterThan(salary);
        return UserDto.toDtoList(activeUsers);
    }


    public List<UserDto> findBySalaryGreaterThanJPQL(long salary) {
        List<User> activeUsers = userRepository.findUsersWithSalaryGreaterThanJPQL(salary);
        return UserDto.toDtoList(activeUsers);
    }

    public List<UserDto> findBySalaryGreaterThanNative(long salary) {
        List<User> activeUsers = userRepository.findUsersWithSalaryGreaterThanNative(salary);
        return UserDto.toDtoList(activeUsers);
    }

    public List<UserDto> findBySalaryBetweenJPA(long minSalary, long maxSalary) {
        List<User> activeUsers = userRepository.findBySalaryBetween(minSalary, maxSalary);
        return UserDto.toDtoList(activeUsers);
    }

    public List<UserDto> findBySalaryBetweenJPQL(long minSalary, long maxSalary) {
        List<User> activeUsers = userRepository.findUsersWithSalaryBetweenJPQL(minSalary, maxSalary);
        return UserDto.toDtoList(activeUsers);
    }

    public List<UserDto> findBySalaryBetweenNative(long minSalary, long maxSalary) {
        List<User> activeUsers = userRepository.findUsersWithSalaryBetweenNative(minSalary, maxSalary);
        return UserDto.toDtoList(activeUsers);
    }

    public long countActiveUsersJPA() {
        return userRepository.countByActiveTrue();
    }

    public long countActiveUsersJPQL() {
        return userRepository.countActiveUsersJPQL();
    }

    public long countActiveUsersNative() {
        return userRepository.countActiveUsersNative();
    }
}
