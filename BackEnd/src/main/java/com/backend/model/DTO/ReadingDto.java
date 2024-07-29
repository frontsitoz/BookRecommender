package com.backend.model.DTO;

import java.time.LocalDateTime;

public class ReadingDto {

    private Long id;
    private Long userId;
    private Long bookId;
    private Boolean isRead;
    private Boolean isReading;
    private Boolean isFavorite;
    private LocalDateTime readAt;

}
