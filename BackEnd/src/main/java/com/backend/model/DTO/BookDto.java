package com.backend.model.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Boolean isBookMarked;
    private Boolean isRead;
    private Boolean isReading;
    private Boolean isLike;
    @JsonBackReference
    private UserDto user;

}
