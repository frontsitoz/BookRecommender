package com.backend.model.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationDto {

    private Long idRecommendation;

    @JsonBackReference(value = "user-recommendations")
    private UserDto user;

    @JsonManagedReference(value = "recommendation-book")
    private BookDto book;

//    @JsonBackReference(value = "user-recommendations")
//    private UserDto user;
//
//    @JsonManagedReference(value = "recommendation-books")
//    private List<BookDto> books;

}
