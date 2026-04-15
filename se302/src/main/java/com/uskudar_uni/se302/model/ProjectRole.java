package com.uskudar_uni.se302.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

import com.uskudar_uni.se302.model.enums.AuthorityType;

@Entity @Table(name = "project_roles")
@Data @NoArgsConstructor @AllArgsConstructor
public class ProjectRole {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Enumerated(EnumType.STRING)
    private AuthorityType authority;

    private String role;

    private boolean isOpen = false;

    @ManyToMany
    @JoinTable(
        name = "project_role_skills",
        joinColumns = @JoinColumn(name = "project_role_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> requiredSkills = new HashSet<>();
}