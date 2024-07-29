package com.backend.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "books")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String title;

    @ElementCollection
    private List<String> authors = new ArrayList<>();

    @Column(length = 255)
    private String description;

    @ElementCollection
    private List<String> genre = new ArrayList<>();

    @Column(length = 255)
    private String publisher;

    @Column(length = 255)
    private String publishedDate;

    @Column(length = 255)
    private String imageUrl;

    @Column(nullable = false)
    private Double pageCount;

    @Column(nullable = false)
    private Boolean isBookMarked;

    @OneToMany(mappedBy = "book")
//    @JsonManagedReference("book-readings")
    private List<Reading> readings;

}
