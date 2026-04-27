package com.uskudar_uni.se302.mapper;

import com.uskudar_uni.se302.dto.auth.RegisterRequestDto;
import com.uskudar_uni.se302.model.User;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {

    public User toUser(RegisterRequestDto dto, String encodedPassword) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail().trim().toLowerCase());
        user.setPassword(encodedPassword);
        user.setUserType(dto.getUserType());
        user.setUniversity(dto.getUniversity());
        user.setDepartment(dto.getDepartment());
        user.setTitle(dto.getTitle());
        user.setYear(dto.getYear() == null ? 0 : dto.getYear());
        return user;
    }
}
