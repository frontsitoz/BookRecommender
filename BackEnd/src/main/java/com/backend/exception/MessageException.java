package com.backend.exception;


import java.time.LocalDateTime;

public record MessageException(
        LocalDateTime time,
        String message,
        String path
) {
}
