package com.uskudar_uni.se302.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import com.uskudar_uni.se302.model.enums.AnnouncementType;

@Entity @Table(name = "announcements")
@Data @NoArgsConstructor @AllArgsConstructor
public class Announcement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date = LocalDate.now();
    
    @ManyToOne @JoinColumn(name = "user_id")
    private User user;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "TEXT")
    private String title;

    @Enumerated(EnumType.STRING)
    private AnnouncementType type;

}