package com.backend.service;

import com.backend.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IBookService extends ICRUD<Book, Long>{

    Optional<Book> findByTitleAndPageCountAndAuthors(String title,
                                                       Double pageCount,
                                                       String authors);

    boolean deleteById(Long id);
}