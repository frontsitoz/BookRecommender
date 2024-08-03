package com.backend.model.DTO;

import lombok.*;

import java.util.List;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ObjectAlgoritmoDto {

    private List<BookDto> books;
    private List<BookDto> recommendations;

//    private int top_n;
}
