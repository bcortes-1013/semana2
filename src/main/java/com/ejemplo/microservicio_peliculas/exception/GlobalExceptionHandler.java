package com.ejemplo.microservicio_peliculas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PeliculaNoEncontradaException.class)
    public ResponseEntity<Map<String, Object>> manejarPeliculaNoEncontrada(PeliculaNoEncontradaException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", 422);
        errorResponse.put("error", "Unprocessable Entity");
        errorResponse.put("message", ex.getMessage());
        errorResponse.put("path", "/peliculas/{id}");

        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}