package com.backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "readings")
@Entity
public class Reading {

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
    private String status;

    @Column(nullable = false)
    private LocalDateTime readAt;
}
