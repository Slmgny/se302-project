package com.uskudar_uni.se302.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.uskudar_uni.se302.model.enums.ProjectType;

@Entity @Table(name = "projects")
@Data @NoArgsConstructor @AllArgsConstructor
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double budget;
    private Integer teamSize;
    private LocalDate date = LocalDate.now();
    private String title;
    
    @Enumerated(EnumType.STRING)
    private ProjectType type;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    private String courseProff;
    private String topic;

    @ManyToMany
    @JoinTable(
        name = "project_skills",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> requiredSkills = new HashSet<>();
}