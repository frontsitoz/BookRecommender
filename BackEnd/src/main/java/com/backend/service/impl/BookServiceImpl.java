package com.backend.service.impl;

import com.backend.model.Book;
import com.backend.repository.IBookRepo;
import com.backend.repository.IGenericRepo;
import com.backend.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl extends CRUDImpl<Book, Long> implements IBookService {

    private final IBookRepo bookRepo;

    @Override
    public IGenericRepo<Book, Long> getRepo() {
        return bookRepo;
    }
}
