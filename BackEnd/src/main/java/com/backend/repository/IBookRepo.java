package com.backend.repository;

import com.backend.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IBookRepo extends IGenericRepo<Book, Long> {


    @Query("SELECT b FROM Book b WHERE b.title = :title AND b.pageCount = :pageCount AND b.authors = :authors")
    Optional<Book> findByTitleAndPageCountAndAuthors(@Param("title") String title,
                                                     @Param("pageCount") Double pageCount,
                                                     @Param("authors") String authors);

    List<Book> findByUserIdUser(String idUser);
}
