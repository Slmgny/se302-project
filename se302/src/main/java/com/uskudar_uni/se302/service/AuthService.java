package com.uskudar_uni.se302.service;

import com.uskudar_uni.se302.dto.auth.RegisterRequestDto;
import com.uskudar_uni.se302.exception.EmailAlreadyExistsException;
import com.uskudar_uni.se302.mapper.AuthMapper;
import com.uskudar_uni.se302.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthMapper authMapper;

    @Transactional
    public void register(RegisterRequestDto registerRequestDto) {
        String normalizedEmail = registerRequestDto.getEmail().trim().toLowerCase();

        if (userRepository.existsByEmail(normalizedEmail)) {
            throw new EmailAlreadyExistsException("This email address is already registered");
        }

        String encodedPassword = passwordEncoder.encode(registerRequestDto.getPassword());
        userRepository.save(authMapper.toUser(registerRequestDto, encodedPassword));
    }
}
