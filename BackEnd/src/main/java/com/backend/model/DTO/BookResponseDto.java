package com.backend.model.DTO;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BookResponseDto {
    private Integer id;
    private String title;
    private String authors;
    private String description;
    private String genre;
    private String publisher;
    private String publishedDate;
    private String imageUrl;
    private Double pageCount;
    private Float averageRating;
    private Boolean isBookMarked;
    private Boolean isRead;
    private Boolean isReading;
    private Boolean isLike;

    // Getters y Setters
}

