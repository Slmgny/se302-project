package com.uskudar_uni.se302.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "skills")
@Data @NoArgsConstructor @AllArgsConstructor
public class Skill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String skill;
}