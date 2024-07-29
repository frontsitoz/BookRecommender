package com.backend.model.DTO;

import com.backend.model.Reading;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookDto {

    private Long id;
    private String title;
    private List<String> authors;
    private String description;
    private List<String> genre;
    private String publisher;
    private String publishedDate;
    private String imageUrl;
    private Double pageCount;
    private Boolean isBookMarked;

    @JsonManagedReference
    private List<Reading> readings;

}
