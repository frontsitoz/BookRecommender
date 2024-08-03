package com.backend.service.api;

import com.backend.model.Book;
import com.backend.model.DTO.BookDto;
import com.backend.model.DTO.BookResponseDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class GoogleBooksClient {

    private static final Logger log = LoggerFactory.getLogger(GoogleBooksClient.class);
    private final RestTemplate restTemplate;
    private final Gson gson;
    private static final String API_KEY = "AIzaSyCrAvZb2kPz17Yy782H-3LlKuljOGw2DZE";
    private static final String BASE_URL = "https://www.googleapis.com/books/v1/volumes?q=";

    public List<BookDto> searchAndPrintBooks(String query, int startIndex, int maxResults) {
        if (query == null || query.isBlank()) {
            String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
            Random random = new Random();
            int index = random.nextInt(lowerCaseLetters.length());
            query = String.valueOf(lowerCaseLetters.charAt(index));
        }
        String url = BASE_URL + query + "&startIndex=" + startIndex + "&maxResults=" + maxResults + "&key=" + API_KEY;
        String response = restTemplate.getForObject(url, String.class);
        Type bookListType = new TypeToken<Map<String, Object>>() {
        }.getType();

        Map<String, Object> jsonResponse = gson.fromJson(response, bookListType);

        assert jsonResponse != null;
//        System.out.println(jsonResponse);
        return processBooks(jsonResponse);
    }

    private List<BookDto> processBooks(Map<String, Object> jsonResponse) {

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> items =
                (List<Map<String, Object>>) jsonResponse.get("items");
        List<BookDto> books = new ArrayList<>();

        if (items != null) {
            for (Map<String, Object> item : items) {
                //Details of the book
                @SuppressWarnings("unchecked")
                Map<String, Object> volumeInfo =
                        (Map<String, Object>) item.get("volumeInfo");

                @SuppressWarnings("unchecked")
                List<String> category = (List<String>) volumeInfo.get("categories");
                if (category == null) {
                    category = new ArrayList<>();
                    category.add("No category");
                }
                String title = (String) volumeInfo.get("title");

                @SuppressWarnings("unchecked")
                Map<String, Object> imageLinks =
                        (Map<String, Object>) volumeInfo.get("imageLinks");
                String thumbnail;
                if (imageLinks == null) {
                    thumbnail = "no image";
                } else {
                    thumbnail = (String) imageLinks.get("thumbnail");
                }
//                    thumbnail = (String) imageLinks.get("thumbnail");

                @SuppressWarnings("unchecked")
                List<String> authors = (List<String>) volumeInfo.get("authors");
                if (authors == null) {
                    authors = new ArrayList<>();
                    authors.add("No author");
                } else {
                    authors = (List<String>) volumeInfo.get("authors");
                }
                String publishedDate = (String) volumeInfo.get("publishedDate");
                String publisher = (String) volumeInfo.get("publisher");
                Object averageRatingObj = volumeInfo.get("averageRating");
                Float averageRating = averageRatingObj != null ? ((Number) averageRatingObj).floatValue() : 0.0f;
                String description = (String) volumeInfo.get("description");
                Double pageCount = (Double) volumeInfo.get("pageCount");

                BookDto book = new BookDto();
                book.setIdBook(null);
                book.setTitle(title != null ? title : "Unknown Title");
                book.setAuthors(authors != null ? authors.toString() : "[Unknown Authors]");
                book.setGenre(category != null ? category.toString() : "[Unknown Category]");
                book.setIsBookMarked(true);
                book.setPageCount(pageCount != null ? pageCount : 0);
                book.setAverageRating(averageRating);
                book.setImageUrl(thumbnail != null ? thumbnail : "http://example.com/default-thumbnail.jpg");
                book.setPublishedDate(publishedDate != null ? publishedDate : "Unknown Date");
                book.setPublisher(publisher != null ? publisher : "Unknown Publisher");
                book.setDescription(description != null ? description : "No Description Available");
                book.setIsBookMarked(false);
                book.setIsRead(false);
                book.setIsReading(false);
                book.setIsLike(false);
                books.add(book);
            }
        } else {
            System.out.println("No books found for the query: ");
        }
        return books;
    }
}