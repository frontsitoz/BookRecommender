package com.backend.controller;

import com.backend.model.Book;
import com.backend.model.DTO.BookDto;
import com.backend.model.DTO.BookResponseDto;
import com.backend.model.DTO.RecommendationDto;
import com.backend.model.RecommendationResponse;
import com.backend.service.IBookService;
import com.backend.service.api.GoogleBooksClient;
import com.backend.service.api.RestAlgoritmo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Tag(name = "Book", description = "Books API")
@RestController
@RequestMapping("api/books")

@ToString
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final IBookService bookService;

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    private final GoogleBooksClient googleBooksClient;

    private final RestAlgoritmo restAlgoritmo;

    @Operation(
            summary = "Get books",
            description = "Get books of the API"
    )
    @GetMapping("/searchBooks/{id}")
    public ResponseEntity<List<BookDto>> searchBooks(
            @PathVariable Long id,
            @RequestParam String query,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "40") int size) throws IOException {

        List<BookDto> bookNews = getBookDtos(query, page, size);
        List<BookDto> dtoBookUser = new ArrayList<>(List.of());
        dtoBookUser = getBooksUser(id, dtoBookUser);

        List<BookDto> sendBooks = restAlgoritmo.sendBooks(bookNews, dtoBookUser);
        //Pagination
//        Pageable pageable = PageRequest.of(page, size);
//        Page<BookDto> bookPage = new PageImpl<>(sendBooks, pageable, sendBooks.size());
        return new ResponseEntity<>(sendBooks, HttpStatus.OK);
    }

    private List<BookDto> getBooksUser(Long id, List<BookDto> dtoBookUser) {
        List<Book> bookUser;
        if (id != null) {
            bookUser = bookService.findByUserIdUser(id.toString());
            dtoBookUser = bookUser.stream().map(this::convertToDto).collect(Collectors.toList());
        }
        return dtoBookUser;
    }

    private List<BookDto> getBookDtos(String query, int page, int size) {
        List<BookDto> bookNews = googleBooksClient.searchAndPrintBooks(query, page * size, size);
        List<BookDto> bookNews2 = googleBooksClient.searchAndPrintBooks(query, page * size, size);
        List<BookDto> bookNews3 = googleBooksClient.searchAndPrintBooks(query, page * size, size);
        List<BookDto> bookNews4 = googleBooksClient.searchAndPrintBooks(query, page * size, size);
        List<BookDto> bookNews5 = googleBooksClient.searchAndPrintBooks(query, page * size, size);

        bookNews.addAll(bookNews2);
        bookNews.addAll(bookNews3);
        bookNews.addAll(bookNews4);
        bookNews.addAll(bookNews5);

        BookDto dto = mapper.map(bookNews, BookDto.class);
        if (dto.getDescription() == null) dto.setDescription("");
        if (dto.getPublisher() == null) dto.setPublisher("");
        if (dto.getAverage_rating() == null) dto.setAverage_rating(0.0f);
        return bookNews;
    }

    @Operation(
            summary = "Get all books",
            description = "Get all books from the database"
    )
    @GetMapping
    public ResponseEntity<List<BookDto>> findAll() {
        List<BookDto> books = bookService.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(books);
    }

    @GetMapping("findBookUser/{idUser}")
    public ResponseEntity<List<BookDto>> findByUser(@PathVariable String idUser) {
        List<BookDto> books =
                bookService
                        .findByUserIdUser(idUser)
                        .stream().map(this::convertToDto).toList();
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
    public ResponseEntity<BookDto> save(@RequestBody BookDto book) {
        if (!isBookAlreadySaved(book.getTitle(), book.getPageCount(), book.getAuthors())) {
            Book savedBook = bookService.save(convertToEntity(book));
            return ResponseEntity.ok(convertToDto(savedBook));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(
            summary = "Update book",
            description = "Update a book in the database"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<BookDto> update(@RequestBody BookDto book, @PathVariable Long id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Book updatedBook = bookService.update(convertToEntity(book), id);
        return ResponseEntity.ok(convertToDto(updatedBook));
    }

    @Operation(
            summary = "Delete book",
            description = "Delete a book from the database"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    /////////////////////////////////////
    private BookDto convertToDto(Book book) {
//        return mapper.map(obj, BookDto.class);
        BookDto bookDto = mapper.map(book, BookDto.class);

        bookDto.setId(Optional.ofNullable(book.getIdBook()).orElse(0L));
        bookDto.setTitle(Optional.ofNullable(book.getTitle()).orElse("No Title"));
        bookDto.setAuthors(Optional.ofNullable(book.getAuthors()).orElse("Unknown Author"));
        bookDto.setDescription(Optional.ofNullable(book.getDescription()).orElse("No Description"));
        bookDto.setGenre(Optional.ofNullable(book.getGenre()).orElse("Unknown Genre"));
        bookDto.setPublisher(Optional.ofNullable(book.getPublisher()).orElse("Unknown Publisher"));
        bookDto.setPublishedDate(Optional.ofNullable(book.getPublishedDate()).orElse("Unknown Date"));
        bookDto.setImageUrl(Optional.ofNullable(book.getImageUrl()).orElse("No Image"));
        bookDto.setPageCount(Optional.ofNullable(book.getPageCount()).orElse(0.0));
        bookDto.setAverage_rating(Optional.ofNullable(book.getAverageRating()).orElse(0.0f));
        bookDto.setIsBookMarked(Optional.ofNullable(book.getIsBookMarked()).orElse(false));
        bookDto.setIsRead(Optional.ofNullable(book.getIsRead()).orElse(false));
        bookDto.setIsReading(Optional.ofNullable(book.getIsReading()).orElse(false));
        bookDto.setIsLike(Optional.ofNullable(book.getIsLiked()).orElse(false));

        return bookDto;
    }

    private Book convertToEntity(BookDto dto) {
        return mapper.map(dto, Book.class);
    }

    public boolean isBookAlreadySaved(String title, Double pageCount, String authors) {
        Optional<Book> existingBook = bookService.findByTitleAndPageCountAndAuthors(title, pageCount, authors);
        return existingBook.isPresent();
    }

}