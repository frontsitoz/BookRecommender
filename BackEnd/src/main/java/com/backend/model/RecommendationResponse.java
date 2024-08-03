package com.backend.model;

import com.backend.model.DTO.BookDto;
import com.backend.model.DTO.BookResponseDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecommendationResponse {

    private List<BookDto> recommendations;

}
