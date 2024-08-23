package com.bootcamp.pragma.stockmicroservice.configuration;

import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.exceptions.BrandAlreadyExistsException;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.exceptions.CategoryAlreadyExistsException;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.exceptions.NoDataFoundException;
import com.bootcamp.pragma.stockmicroservice.domain.exception.EmptyFieldException;
import com.bootcamp.pragma.stockmicroservice.domain.exception.ExceedFielException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.bootcamp.pragma.stockmicroservice.configuration.Constants.*;
import static com.bootcamp.pragma.stockmicroservice.domain.util.DomainConstants.FIELD_NAME_LENGTH_MESSAGE;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleCategoryNameAlreadyExistsException(CategoryAlreadyExistsException categoryAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, CATEGORY_ALREADY_EXISTS_MESSAGE));
    }

    @ExceptionHandler(BrandAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleBrandNameAlreadyExistsException(BrandAlreadyExistsException brandAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, BRAND_ALREADY_EXISTS_MESSAGE));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(NoDataFoundException noDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, NO_DATA_FOUND_MESSAGE));
    }

    @ExceptionHandler(EmptyFieldException.class)
    public ResponseEntity<Map<String, String>> emptyFieldException(EmptyFieldException emptyFieldException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, FIELD_EMPTY_MESSAGE));
    }

    @ExceptionHandler(ExceedFielException.class)
    public ResponseEntity<Map<String, String>> exceedFielException(ExceedFielException exceedFielException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, FIELD_NAME_LENGTH_MESSAGE));
    }
}
