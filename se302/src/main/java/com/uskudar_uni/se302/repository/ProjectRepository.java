package com.uskudar_uni.se302.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uskudar_uni.se302.model.Project;
import com.uskudar_uni.se302.model.enums.ProjectType;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p JOIN p.requiredSkills s WHERE s.skill = :skillName AND p.type = :projectType")
    List<Project> findBySkillAndType(@Param("skillName") String skillName, @Param("projectType") ProjectType projectType);

    @Query("SELECT p FROM Project p JOIN p.requiredSkills s WHERE s.skill = :skillName")
    List<Project> findBySkillName(@Param("skillName") String skillName);
}