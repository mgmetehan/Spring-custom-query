package com.mgmetehan.customquery.dto;

import com.mgmetehan.customquery.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String username;
    private boolean active;
    private long salary;
    private Date birthDate;

    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setActive(userDto.isActive());
        user.setSalary(userDto.getSalary());
        user.setBirthDate(userDto.getBirthDate());
        return user;
    }

    public static UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setActive(user.isActive());
        userDto.setSalary(user.getSalary());
        userDto.setBirthDate(user.getBirthDate());
        return userDto;
    }

    public static List<UserDto> toDtoList(List<User> users) {
        return users.stream().map(UserDto::toDto).collect(Collectors.toList());
    }
}
