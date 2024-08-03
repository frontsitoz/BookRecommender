package com.backend.controller;

import com.backend.model.Recommendation;
import com.backend.model.DTO.RecommendationDto;
import com.backend.model.Recommendation;
import com.backend.service.IRecommendationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/recommendations")
@RequiredArgsConstructor
public class RecommendationController {

    private final IRecommendationService recommendationService;

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<RecommendationDto>> findAll() {
        List<RecommendationDto> recommendations = recommendationService
                .findAll()
                .stream().map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(List.of());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecommendationDto> findById(@PathVariable Long id) {
        RecommendationDto recommendation =
                convertToDto(recommendationService.findById(id));
        return ResponseEntity.ok(recommendation);
    }

    @PostMapping
    public ResponseEntity<RecommendationDto> save(@RequestBody RecommendationDto recommendation) {
        Recommendation savedRecommendation =
                recommendationService.save(convertToEntity(recommendation));
        return ResponseEntity.ok(convertToDto(savedRecommendation));
    }

    @PostMapping("/favorite")
    public ResponseEntity<RecommendationDto> saveFavoriteRecommendation(@RequestBody RecommendationDto recommendation) {
        Recommendation savedRecommendation =
                recommendationService.save(convertToEntity(recommendation));
        return ResponseEntity.ok(convertToDto(savedRecommendation));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecommendationDto> update(@RequestBody RecommendationDto recommendation, @PathVariable Long id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Recommendation updatedRecommendation =
                recommendationService
                        .update(convertToEntity(recommendation), id);
        return ResponseEntity.ok(convertToDto(updatedRecommendation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        recommendationService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    /////////////////////////////////////
    private RecommendationDto convertToDto(Recommendation obj){
        return mapper.map(obj, RecommendationDto.class);
    }

    private Recommendation convertToEntity(RecommendationDto dto){
        return mapper.map(dto, Recommendation.class);
    }
}
