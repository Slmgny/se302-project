package com.uskudar_uni.se302.repository;

import com.uskudar_uni.se302.model.ProjectRole;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRoleRepository extends JpaRepository<ProjectRole, Long> {
    List<ProjectRole> findByProjectId(Long projectId);
}