package com.backend.controller;

import com.backend.model.Recommendation;
import com.backend.service.IRecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/recommendations")
@RequiredArgsConstructor
public class RecommendationController {

    private final IRecommendationService recommendationService;

    @GetMapping
    public ResponseEntity<Page<Recommendation>> findAll(Pageable pageable) {
        Page<Recommendation> recommendations = recommendationService.findAll(pageable);
        return ResponseEntity.ok(recommendations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recommendation> findById(@PathVariable Long id) {
        Recommendation recommendation = recommendationService.findById(id);
        return ResponseEntity.ok(recommendation);
    }

    @PostMapping
    public ResponseEntity<Recommendation> save(@RequestBody Recommendation recommendation) {
        Recommendation savedRecommendation = recommendationService.save(recommendation);
        return ResponseEntity.ok(savedRecommendation);
    }

    @PostMapping("/favorite")
    public ResponseEntity<Recommendation> saveFavoriteRecommendation(@RequestBody Recommendation recommendation) {
        Recommendation savedRecommendation = recommendationService.save(recommendation);
        return ResponseEntity.ok(savedRecommendation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recommendation> update(@RequestBody Recommendation recommendation, @PathVariable Long id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Recommendation updatedRecommendation = recommendationService.update(recommendation, id);
        return ResponseEntity.ok(updatedRecommendation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        recommendationService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
