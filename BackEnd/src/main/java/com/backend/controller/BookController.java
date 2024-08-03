package com.backend.controller;

import com.backend.model.Book;
import com.backend.model.DTO.BookDto;
import com.backend.service.IBookService;
import com.backend.service.api.GoogleBooksClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Tag(name = "Book", description = "Books API")
@RestController
@RequestMapping("api/books")

@RequiredArgsConstructor
public class BookController {

    private final IBookService bookService;

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    private final GoogleBooksClient googleBooksClient;

    @Operation(
            summary = "Get books",
            description = "Get books of the API"
    )
    @GetMapping("/searchBooks")
    public ResponseEntity<Page<BookDto>> searchBooks(
            @RequestParam String query,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "40") int size) {

        List<BookDto> bookDtos = googleBooksClient.searchAndPrintBooks(query, page * size, size);
        Pageable pageable = PageRequest.of(page, size);
        Page<BookDto> bookPage = new PageImpl<>(bookDtos, pageable, bookDtos.size());
        return new ResponseEntity<>(bookPage, HttpStatus.OK);
    }

    @Operation(
            summary = "Get all books",
            description = "Get all books from the database"
    )
    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        List<Book> books = bookService.findAll();
        return ResponseEntity.ok(books);
    }

    @Operation(
            summary = "Get book by id",
            description = "Get a book by id from the database"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        return ResponseEntity.ok(book);
    }

    @Operation(
            summary = "Save book",
            description = "Save a book in the database"
    )
    @PostMapping("/save")
    public ResponseEntity<BookDto> save(@RequestBody BookDto bookDto) {
        Optional<Book> existingBook = bookService.findByTitleAndPageCountAndAuthors(
            bookDto.getTitle(), bookDto.getPageCount(), bookDto.getAuthors());
        
        if (existingBook.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(convertToDto(existingBook.get()));
        }
        
        Book book = convertToEntity(bookDto);
        Book savedBook = bookService.save(book);
        return ResponseEntity.ok(convertToDto(savedBook));
    }

//
//    @PostMapping("/favorite")
//    public ResponseEntity<Book> saveFavoriteBook(@RequestBody Book book) {
//        book.setIsBookMarked(true);
//        Book savedBook = bookService.save(book);
//        return ResponseEntity.ok(savedBook);
//    }

    @Operation(
            summary = "Update book",
            description = "Update a book in the database"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<BookDto> update(@RequestBody BookDto bookDto, @PathVariable Long id) {
        try {
            Book book = convertToEntity(bookDto);
            Book updatedBook = bookService.update(book, id);
            return ResponseEntity.ok(convertToDto(updatedBook));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(
            summary = "Delete book",
            description = "Delete a book from the database"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            boolean deleted = bookService.deleteById(id);
            if (deleted) {
                return ResponseEntity.ok().body("Libro eliminado exitosamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Libro no encontrado con ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al eliminar el libro: " + e.getMessage());
        }
    }

    /////////////////////////////////////
    private BookDto convertToDto(Book obj) {
        return mapper.map(obj, BookDto.class);
    }

    private Book convertToEntity(BookDto dto) {
        return mapper.map(dto, Book.class);
    }

    public boolean isBookAlreadySaved(String title, Double pageCount, String authors) {
        Optional<Book> existingBook = bookService.findByTitleAndPageCountAndAuthors(title, pageCount, authors);
        return existingBook.isPresent();
    }
}