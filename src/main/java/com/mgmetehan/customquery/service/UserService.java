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
}
