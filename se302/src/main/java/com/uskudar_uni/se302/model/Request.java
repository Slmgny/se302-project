package com.uskudar_uni.se302.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.uskudar_uni.se302.model.enums.RequestStatus;
import com.uskudar_uni.se302.model.enums.RequestType;

@Entity @Table(name = "requests")
@Data @NoArgsConstructor @AllArgsConstructor
public class Request {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date = LocalDateTime.now();

    @ManyToOne @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne @JoinColumn(name = "receiver_id")
    private User receiver;

    @ManyToOne @JoinColumn(name = "project_id")
    private Project project;

    @Enumerated(EnumType.STRING)
    private RequestType type;

    @Enumerated(EnumType.STRING)
    private RequestStatus status = RequestStatus.PENDING;
}