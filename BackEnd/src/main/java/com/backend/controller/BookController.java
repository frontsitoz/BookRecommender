package com.backend.controller;


import com.backend.model.Book;
import com.backend.repository.IUserRepo;
import com.backend.service.IBookService;
import com.backend.service.ICRUD;
import com.backend.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("api/books")

@RequiredArgsConstructor
public class BookController {

    private final IBookService bookService;

    @GetMapping
    public ResponseEntity<Page<Book>> findAll(Pageable pageable) {
        Page<Book> books = bookService.findAll(pageable);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody Book book) {
        Book savedBook = bookService.save(book);
        return ResponseEntity.ok(savedBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@RequestBody Book book, @PathVariable Long id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Book updatedBook = bookService.update(book, id);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}