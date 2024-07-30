package com.backend.model.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {

    private Long idUser;
    private String username;

    private String passwordHash;
    private String email;
    private LocalDateTime createdAt;

    @JsonManagedReference
    private List<BookDto> books;

    private List<RecommendationDto> recommendations;
}
