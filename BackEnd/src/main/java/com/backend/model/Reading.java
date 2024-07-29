package com.backend.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "readings")
@Entity
public class Reading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
//    @JsonBackReference("user-readings")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
//    @JsonBackReference("book-readings")
    private Book book;

    @Column(nullable = false)
    private Boolean isRead;

    @Column(nullable = false)
    private Boolean isReading;

    @Column(nullable = false)
    private Boolean isFavorite;

    @Column(nullable = false)
    private LocalDateTime readAt;
}

