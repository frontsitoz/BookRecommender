package com.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "books")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(length = 255)
    private String subtitle;

    @Column(length = 255)
    private String authors;

    @Column(length = 255)
    private String publisher;

    @Column(length = 10)
    private String publishedDate;

    @Column(length = 2000)
    private String description;

    @Column(nullable = false)
    private Integer pageCount;

    @Column(length = 10)
    private String language;

    @Column(length = 255)
    private String previewLink;

    @Column(length = 255)
    private String infoLink;

    @Column(length = 255)
    private String thumbnailLink;
}
