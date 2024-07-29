package com.backend.service.impl;

import com.backend.model.Book;
import com.backend.model.Reading;
import com.backend.repository.IReadingRepo;
import com.backend.repository.IGenericRepo;
import com.backend.service.IReadingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadingServiceImpl extends CRUDImpl<Reading, Long> implements IReadingService {

    private final IReadingRepo readingRepo;

    @Override
    public IGenericRepo<Reading, Long> getRepo() {
        return readingRepo;
    }

    @Override
    public List<Reading> findReadingsByUserId(Long userId) {
        return readingRepo.findReadingsByUserId(userId);
    }
}
