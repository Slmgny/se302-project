package com.uskudar_uni.se302.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uskudar_uni.se302.model.ProjectRole;
import com.uskudar_uni.se302.model.User;
import com.uskudar_uni.se302.repository.ProjectRoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectRoleService {
    private final ProjectRoleRepository projectRoleRepository;

    public List<User> getUsersInProject(Long projectId) {
        return projectRoleRepository.findByProjectId(projectId)
                .stream()
                .map(ProjectRole::getUser)
                .toList();
    }
}