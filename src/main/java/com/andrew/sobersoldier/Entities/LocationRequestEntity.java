package com.andrew.sobersoldier.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


public class LocationRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private LocalDateTime requestTime = LocalDateTime.now();

    @Column(nullable = false, length = 50)
    private String status = "PENDING";
}
