package com.uskudar_uni.se302.repository;

import com.uskudar_uni.se302.model.ProjectRole;
import com.uskudar_uni.se302.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRoleRepository extends JpaRepository<ProjectRole, Long> {
    List<ProjectRole> findByProjectId(Long projectId);

    @Query("SELECT DISTINCT pr.project FROM ProjectRole pr WHERE pr.user.id = :userId")
    List<Project> findProjectsByUserId(@Param("userId") Long userId);
}