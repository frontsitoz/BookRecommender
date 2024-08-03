package com.backend.service.api;

import com.backend.model.DTO.BookDto;
import com.backend.model.RecommendationRequest;
import com.backend.model.RecommendationResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@Slf4j

public class RestAlgoritmo {

        @Autowired
        private RestTemplate restTemplate;
//    private ModelMapper mapper;
    //    private final String RECOMMENDATION_URL = ;
    private final Gson json;

    // Constructor que configura una instancia de Gson internamente
    public RestAlgoritmo() {
        this.json = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
    }

    public List<BookDto> sendBooks(List<BookDto> bookNews, List<BookDto> bookUser) {

        String url = "http://localhost:8000/getRecommendations";
        RecommendationRequest request = new RecommendationRequest(bookUser, bookNews);
        String jsonRequest = json.toJson(request);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequest, headers);
        ResponseEntity<List<BookDto>> responseEntity = restTemplate.exchange(
                url, HttpMethod.POST, requestEntity, new ParameterizedTypeReference<>() {
                }
        );
        System.out.println("tamaño de response:" + responseEntity.getBody().size());
        return responseEntity.getBody();
    }

//    public List<BookDto> getBookRecommendations(List<BookDto> bookNews, List<BookDto> bookUser) {
//        String url = "http://127.0.0.1:8000/getRecommendations";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        RecommendationRequest request = new RecommendationRequest(bookNews, bookUser);
//
//        HttpEntity<RecommendationRequest> entity = new HttpEntity<>(request, headers);
//
//        ResponseEntity<List<BookDto>> response = restTemplate.exchange(
//                url,
//                HttpMethod.POST,
//                entity,
//                new ParameterizedTypeReference<List<BookDto>>() {
//                }
//        );
//        System.out.println("response = " + response);
//        return response.getBody();
//    }

//    public List<BookDto> getBookRecommendations(List<BookDto> list1, List<BookDto> list2) throws IOException {
//        String url = "http://127.0.0.1:8000/getRecommendations";
//
//        // Crear un objeto que contenga ambas listas
//        RecommendationRequest request = new RecommendationRequest(list1, list2);
//        String jsonRequest = json.toJson(request);
//
////        log.info("JSON Request: " + jsonRequest);
//
//        // Crear la solicitud POST
//        HttpPost post = new HttpPost(url);
//        post.setHeader("Content-Type", "application/json");
//        post.setEntity(new StringEntity(jsonRequest));
//
//        // Crear el cliente HTTP y ejecutar la solicitud
//        try (CloseableHttpClient client = HttpClients.createDefault()) {
//            HttpResponse response = client.execute(post);
//            HttpEntity entity = response.getEntity();
//
//            if (entity != null) {
//                String jsonResponse = EntityUtils.toString(entity);
//                log.info("JSON Response: " + jsonResponse);
//
//                Type listType = new TypeToken<List<BookDto>>() {
//                }.getType();
//                return json.fromJson(jsonResponse, listType);
//            } else {
//                log.info("Response contains no content");
//                throw new RuntimeException("Response contains no content");
//            }
//        }
//    }

//    private BookResponseDto convertToDto(BookDto obj) {
//        return mapper.map(obj, BookResponseDto.class);
//    }
//
//    private BookDto convertToEntity(BookResponseDto dto) {
//        return mapper.map(dto, BookDto.class);
//    }
}

