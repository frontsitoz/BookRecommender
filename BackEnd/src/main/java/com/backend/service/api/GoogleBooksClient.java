package com.backend.service.api;

import com.backend.model.Book;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoogleBooksClient {

    private final RestTemplate restTemplate;
    private final Gson gson;
    private static final String API_KEY = "AIzaSyCrAvZb2kPz17Yy782H-3LlKuljOGw2DZE";
    private static final String BASE_URL = "https://www.googleapis.com/books/v1/volumes?q=";

    public void searchAndPrintBooks(String query) {

        String url = BASE_URL + query + "&key=" + API_KEY;
        String response = restTemplate.getForObject(url, String.class);
        // Procesando la respuesta con GSON
        Type bookListType = new TypeToken <Map<String, Object>>() {}.getType();

        Map<String, Object> jsonResponse = gson.fromJson(response, bookListType);

        System.out.println(jsonResponse);
        assert jsonResponse != null;
        processBooks(jsonResponse);
    }

    private void processBooks(Map<String, Object> jsonResponse) {

        List<Map<String, Object>> items =
                (List<Map<String, Object>>) jsonResponse.get("items");

        if (items != null) {
            for (Map<String, Object> item : items) {
                Map<String, Object> volumeInfo =
                        (Map<String, Object>) item.get("volumeInfo");
                List<String> category = (List<String>) volumeInfo.get("categories");
                String title = (String) volumeInfo.get("title");
                List<String> authors = (List<String>) volumeInfo.get("authors");
                String description = (String) volumeInfo.get("description");

                System.out.println("Title: " + title);
                System.out.println("Categories: " + category);
                System.out.println("Authors: " + (authors != null ? String.join(", ", authors) : "Unknown author"));
                System.out.println("Description: " + (description != null ? description : "No description available."));
                System.out.println("------");
            }
        } else {
            System.out.println("No books found for the query: ");
        }
    }
}