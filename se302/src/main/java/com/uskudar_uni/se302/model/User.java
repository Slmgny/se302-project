package com.uskudar_uni.se302.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

import com.uskudar_uni.se302.model.enums.UserType;


@Entity @Table(name = "users")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;
    private String name;
    private String department;
    private String title;
    private boolean available = true;
    private int year;
    private String links;
    @Column(columnDefinition = "TEXT")
    private String bio;
    private String profilePic;
    private String university;

    @ManyToMany
    @JoinTable(
        name = "user_skills",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills = new HashSet<>();
}

