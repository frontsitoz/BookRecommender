package com.backend.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleBooksClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${google.books.api.url}")
    private String googleBooksApiUrl;

    public String searchBooks(String query) {
        String url = googleBooksApiUrl + "?q=" + query;
        return restTemplate.getForObject(url, String.class);
    }
}