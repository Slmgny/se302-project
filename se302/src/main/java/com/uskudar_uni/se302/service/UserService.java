package com.uskudar_uni.se302.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uskudar_uni.se302.model.User;
import com.uskudar_uni.se302.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    // Skill ve Availability ile user bulma
    public List<User> searchUsersBySkill(String skillName, Boolean available) {
        if (available == null) {
            return userRepository.findBySkillName(skillName);
        }
        return userRepository.findBySkillNameAndAvailable(skillName, available);
    }

    public User saveUser(User user) { return userRepository.save(user); }
    public List<User> getAllUsers() { return userRepository.findAll(); }
}