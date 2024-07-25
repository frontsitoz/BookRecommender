package com.backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "recommendations")
@Entity
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private LocalDateTime recommendedAt;
}
