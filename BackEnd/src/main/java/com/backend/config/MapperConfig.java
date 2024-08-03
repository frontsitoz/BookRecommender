package com.backend.config;

import com.backend.model.Book;
import com.backend.model.DTO.BookDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean("defaultMapper")
    public ModelMapper defaultMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        // Evitar referencias circulares en la conversión
        modelMapper.addMappings(new PropertyMap<Book, BookDto>() {
            @Override
            protected void configure() {
                skip(destination.getUser());
                skip(destination.getRecommendation());
            }
        });
        return modelMapper;
    }
}
