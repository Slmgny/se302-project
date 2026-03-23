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

    @ManyToOne @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne @JoinColumn(name = "project_id")
    private Project project;

    @Enumerated(EnumType.STRING)
    private AuthorityType authority;

    private String role;
}