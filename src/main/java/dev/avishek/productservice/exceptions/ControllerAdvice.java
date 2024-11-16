package dev.avishek.productservice.exceptions;

import dev.avishek.productservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionDto> handleNotFoundException(Exception ex) {
        ExceptionDto error = new ExceptionDto(HttpStatus.NOT_FOUND, ex.getMessage());
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        return response;
    }
}
