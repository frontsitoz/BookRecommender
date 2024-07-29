package com.backend.controller;

import com.backend.model.Reading;
import com.backend.model.Reading;
import com.backend.service.IReadingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/readings")
@RequiredArgsConstructor
//@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class ReadingController {

    private final IReadingService readingService;

    @GetMapping
    public ResponseEntity<Page<Reading>> findAll(Pageable pageable) {
        Page<Reading> readings = readingService.findAll(pageable);
        return ResponseEntity.ok(readings);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Reading>> getReadingsByUserId(@PathVariable Long userId) {
        List<Reading> readings = readingService.findReadingsByUserId(userId);
        if (readings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(readings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reading> findById(@PathVariable Long id) {
        Reading reading = readingService.findById(id);
        return ResponseEntity.ok(reading);
    }

    @PostMapping("/save")
    public ResponseEntity<Reading> save(@RequestBody Reading reading) {
        Reading savedReading = readingService.save(reading);
        return ResponseEntity.ok(savedReading);
    }

//    @PostMapping("/favorite")
//    public ResponseEntity<Reading> saveFavoriteReading(@RequestBody Reading reading) {
//        Reading savedReading = readingService.save(reading);
//        return ResponseEntity.ok(savedReading);
//    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Reading> update(@RequestBody Reading reading, @PathVariable Long id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Reading updatedReading = readingService.update(reading, id);
        return ResponseEntity.ok(updatedReading);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        readingService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
