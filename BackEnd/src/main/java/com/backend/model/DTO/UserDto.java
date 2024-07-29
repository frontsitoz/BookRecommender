package com.backend.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {

    private Long id;
    private String username;
    private String email;
    private LocalDateTime createdAt;
    private List<ReadingDto> readings;
    private List<RecommendationDto> recommendations;
}
