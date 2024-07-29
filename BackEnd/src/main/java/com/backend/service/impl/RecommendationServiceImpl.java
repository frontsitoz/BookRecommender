package com.backend.service.impl;

import com.backend.model.Recommendation;
import com.backend.repository.IGenericRepo;
import com.backend.repository.IRecommendationRepo;
import com.backend.service.IRecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl extends CRUDImpl<Recommendation, Long> implements IRecommendationService {

    private final IRecommendationRepo recommendationRepo;

    @Override
    public IGenericRepo<Recommendation, Long> getRepo() {
        return recommendationRepo;
    }
}
