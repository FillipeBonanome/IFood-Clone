package com.ifoodclone.IFood.Clone.infra.handler;

import com.ifoodclone.IFood.Clone.infra.exception.RestaurantException;
import com.ifoodclone.IFood.Clone.infra.exception.UserException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleError404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorDTO>> handleError400(MethodArgumentNotValidException exception) {
        var errors = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(ValidationErrorDTO::new).toList());
    }

    @ExceptionHandler(RestaurantException.class)
    public ResponseEntity<String> handleRestaurantError(RestaurantException exception) {
        var message = exception.getMessage();
        return ResponseEntity.badRequest().body(message);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<String> handleUserError(UserException exception) {
        var message = exception.getMessage();
        return ResponseEntity.badRequest().body(message);
    }

    public record ValidationErrorDTO(String field, String message) {
        public ValidationErrorDTO(FieldError e) {
            this(e.getField(), e.getDefaultMessage());
        }
    }

}
