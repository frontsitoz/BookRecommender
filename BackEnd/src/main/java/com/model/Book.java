package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Book {

    @Id
    @EqualsAndHashCode.Include
    private Long id;  // Usaremos el ID de Google Books como el ID de nuestro libro.

    private String title;

    @ElementCollection
    private Set<String> autors;

    @Column(length = 2000)
    private String description;

    @ElementCollection
    private Set<String> categories;

    private String thumbnail;

    private double averageRating;
}
