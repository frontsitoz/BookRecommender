package com.backend.model.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import lombok.*;

import java.util.List;

@Getter
@Setter

@NoArgsConstructor
@ToString
public class BookDto {

    private Long id;
    private String title;
    private String authors;
    private String description;
    private String genre;
    private String publisher;
    private String publishedDate;
    private String imageUrl;
    private Double pageCount;
    private Float average_rating = 0.0f;
    private Boolean isBookMarked = false;
    private Boolean isRead = false;
    private Boolean isReading = false;
    private Boolean isLike = false;

    @JsonBackReference(value = "user-books")
    private UserDto user;

    @JsonBackReference(value = "recommendation-book")
    private RecommendationDto recommendation;

    public BookDto(Long id, String title, String authors, String description, String genre, String publisher, String publishedDate, String imageUrl, Double pageCount, Float average_rating, Boolean isBookMarked, Boolean isRead, Boolean isReading, Boolean isLike, UserDto user, RecommendationDto recommendation) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.description = description;
        this.genre = genre;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.imageUrl = imageUrl;
        this.pageCount = pageCount;
        this.average_rating = average_rating;
        this.isBookMarked = isBookMarked;
        this.isRead = isRead;
        this.isReading = isReading;
        this.isLike = isLike;
        this.user = user;
        this.recommendation = recommendation;
    }
}
