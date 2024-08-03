package com.backend.model.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String idUser;
    private String username;

    @Email
    private String email;
    private LocalDateTime createdAt;

    @JsonManagedReference(value = "user-books")
    private List<BookDto> books;

    @JsonManagedReference(value = "user-recommendations")
    private List<RecommendationDto> recommendations;

}
