package com.uskudar_uni.se302.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.math.BigDecimal;

import com.uskudar_uni.se302.model.enums.ProjectType;
import com.uskudar_uni.se302.model.enums.ProjectStatus;

@Entity @Table(name = "projects")
@Data @NoArgsConstructor @AllArgsConstructor
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal budget;

    private Integer teamSize;

    private LocalDate date = LocalDate.now();

    private String title;
    
    @Enumerated(EnumType.STRING)
    private ProjectType type;
    
    @Column(name = "\"desc\"", columnDefinition = "TEXT")
    private String desc;

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private User advisor;

    private String topic;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status;
}