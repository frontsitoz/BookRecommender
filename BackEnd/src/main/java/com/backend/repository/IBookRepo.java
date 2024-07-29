package com.backend.repository;

import com.backend.model.Book;

import java.util.List;

public interface IBookRepo extends IGenericRepo<Book, Long>{

    List<Book> findAllByReadings(Long userId);
}
