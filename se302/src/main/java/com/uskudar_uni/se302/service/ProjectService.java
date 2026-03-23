package com.uskudar_uni.se302.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uskudar_uni.se302.model.Project;
import com.uskudar_uni.se302.model.enums.ProjectType;
import com.uskudar_uni.se302.repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    // İhtiyaç olunan skill ve istenilen türde proje bulma
    public List<Project> searchProjectsBySkill(String skill, ProjectType type) {
        if (type == null) {
            return projectRepository.findBySkillName(skill);
        }
        return projectRepository.findBySkillAndType(skill, type);
    }

    public Project saveProject(Project project) { return projectRepository.save(project); }
    public List<Project> getAllProjects() { return projectRepository.findAll(); }
}