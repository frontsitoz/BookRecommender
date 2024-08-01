package com.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Table(name = "book")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;

    @Column(length = 255)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String authors;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String genre;

    @Column(length = 255)
    private String publisher;

    @Column(length = 255)
    private String publishedDate;

    @Column(length = 255, nullable = true)
    private String imageUrl;

    @Column(nullable = false)
    private Double pageCount;

    private Integer rating;

    private Boolean isBookMarked;

    private Boolean isRead;

    private Boolean isReading;

    private Boolean isLiked;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = true)
    private User user;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_recommendation", nullable = true)
//    private Recommendation recommendation;
}
