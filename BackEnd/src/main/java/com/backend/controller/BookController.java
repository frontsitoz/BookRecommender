package com.backend.controller;


import com.backend.model.Book;
import com.backend.model.DTO.BookDto;
import com.backend.service.IBookService;
import com.backend.service.api.GoogleBooksClient;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("api/books")

@RequiredArgsConstructor
public class BookController {

    private final IBookService bookService;

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    private final GoogleBooksClient googleBooksClient;

    @GetMapping("/searchBooks")
    public ResponseEntity<List<BookDto>> searchBooks(@RequestParam String query) {
        List<BookDto> list = googleBooksClient.searchAndPrintBooks(query).stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        List<Book> books = bookService.findAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<BookDto> save(@RequestBody BookDto book) {
        Book savedBook = bookService.save(convertToEntity(book));
        return ResponseEntity.ok(convertToDto(savedBook));
    }

    @PostMapping("/favorite")
    public ResponseEntity<Book> saveFavoriteBook(@RequestBody Book book) {
        book.setIsBookMarked(true);
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

    /////////////////////////////////////
    private BookDto convertToDto(Book obj){
        return mapper.map(obj, BookDto.class);
    }

    private Book convertToEntity(BookDto dto){
        return mapper.map(dto, Book.class);
    }

}