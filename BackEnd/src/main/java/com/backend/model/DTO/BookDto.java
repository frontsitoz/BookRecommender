package com.backend.model.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookDto {

    private Long idBook;
    private String title;
    private String authors;
    private String description;
    private String genre;
    private String publisher;
    private String publishedDate;
    private String imageUrl;
    private Double pageCount;
    private Integer rating;
    private Boolean isBookMarked;
    private Boolean isRead;
    private Boolean isReading;
    private Boolean isLike;

    @JsonBackReference(value = "user-books")
    private UserDto user;

    @JsonBackReference(value = "recommendation-book")
    private RecommendationDto recommendation;
}
