package com.backend.service.impl;

import com.backend.model.Book;
import com.backend.repository.IBookRepo;
import com.backend.repository.IGenericRepo;
import com.backend.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl extends CRUDImpl<Book, Long> implements IBookService {

    private final IBookRepo bookRepo;

    @Override
    public IGenericRepo<Book, Long> getRepo() {
        return bookRepo;
    }

    @Override
    public Optional<Book> findByTitleAndPageCountAndAuthors(String title, Double pageCount, String authors) {
        return bookRepo.findByTitleAndPageCountAndAuthors(title, pageCount, authors);
    }

    @Override
    public Book save(Book book) {
        // Asegurarse de que el ID del libro no sea nulo
        if (book.getIdBook() == null) {
            book.setIdBook(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
        }
        return bookRepo.save(book);
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<Book> bookOptional = bookRepo.findById(id);
        if (bookOptional.isPresent()) {
            bookRepo.deleteById(id);
            return true;
        }
        return false;
    }
}