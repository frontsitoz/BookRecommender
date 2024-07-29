package com.backend.service.api;

import com.backend.model.Book;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;
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

    public List<Book> searchAndPrintBooks(String query) {

        String url = BASE_URL + query + "&key=" + API_KEY;
        String response = restTemplate.getForObject(url, String.class);
        // Procesando la respuesta con GSON
        Type bookListType = new TypeToken <Map<String, Object>>() {}.getType();

        Map<String, Object> jsonResponse = gson.fromJson(response, bookListType);

        System.out.println(jsonResponse);
        assert jsonResponse != null;
        return processBooks(jsonResponse);
    }

    private List<Book> processBooks(Map<String, Object> jsonResponse) {

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> items =
                (List<Map<String, Object>>) jsonResponse.get("items");
        List<Book> books = new ArrayList<>();

        if (items != null) {
            for (Map<String, Object> item : items) {
                //Details of the book
                @SuppressWarnings("unchecked")
                Map<String, Object> volumeInfo =
                        (Map<String, Object>) item.get("volumeInfo");

                //Mapping the details of the book
                @SuppressWarnings("unchecked")
                List<String> category = (List<String>) volumeInfo.get("categories");
                String title = (String) volumeInfo.get("title");

                @SuppressWarnings("unchecked")
                Map<String, Object> imageLinks =
                        (Map<String, Object>) volumeInfo.get("imageLinks");

                @SuppressWarnings("unchecked")
                List<String> authors = (List<String>) volumeInfo.get("authors");
                String publishedDate = (String) volumeInfo.get("publishedDate");
                String publisher= (String) volumeInfo.get("publisher");
                String description = (String) volumeInfo.get("description");
                Double pageCount = (Double) volumeInfo.get("pageCount");

                String thumbnail = (String) imageLinks.get("thumbnail");
//                System.out.println("thumbnail = " + thumbnail);
                //Creating a new book object
                Book book = new Book();
                book.setTitle(title);
                book.setAuthors(authors);
                book.setGenre(category);
                book.setIsBookMarked(true);
                book.setPageCount(pageCount);
                book.setImageUrl(thumbnail);
                book.setPublishedDate(publishedDate);
                book.setPublisher(publisher);
                book.setDescription(description);

                books.add(book);
//                System.out.println("book = " + book);
//                System.out.println("Title: " + title);
//                System.out.println("Categories: " + category);
//                System.out.println("publisher = " + publisher);
//                System.out.println("publishedDate = " + publishedDate);
//                System.out.println("Authors: " + (authors != null ? String.join(", ", authors) : "Unknown author"));
//                System.out.println("Description: " + (description != null ? description : "No description available."));
//                System.out.println("------");
            }
        } else {
            System.out.println("No books found for the query: ");
        }
        return books;
    }
}