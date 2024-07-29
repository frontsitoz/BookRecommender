package com.backend.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationDto {

    private Long id;
    private Long userId;
    private Long bookId;
    private String recommendationText;
    private LocalDateTime recommendedAt;
}
