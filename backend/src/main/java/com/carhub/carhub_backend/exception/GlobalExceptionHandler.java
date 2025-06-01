package com.carhub.carhub_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// This annotation tells Spring: "This class handles exceptions globally for REST controllers"
@RestControllerAdvice
public class GlobalExceptionHandler {

    // This method handles validation errors caused by @Valid annotation
    // For example, if a field is blank but it's marked @NotBlank, this will catch the error
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {

        // Create a map to hold field-specific error messages
        Map<String, String> errors = new HashMap<>();

        // Loop through all field errors
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            // Get the name of the field (e.g., "make", "model") and the default error message
            errors.put(error.getField(), error.getDefaultMessage());
        });

        // Return the error map along with HTTP 400 Bad Request status
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // Handle CarNotFoundException thrown by service layer
    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<String> handleCarNotFound(CarNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }







}
