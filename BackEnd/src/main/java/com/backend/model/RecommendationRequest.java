package com.backend.model;

import com.backend.model.DTO.BookDto;
import com.backend.model.DTO.BookResponseDto;
import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class RecommendationRequest {

    private List<BookDto> user_books;
    private List<BookDto> all_books;

    public RecommendationRequest(List<BookDto> user_books, List<BookDto> content) {
        this.user_books = user_books;
        this.all_books = content;

    }
}
