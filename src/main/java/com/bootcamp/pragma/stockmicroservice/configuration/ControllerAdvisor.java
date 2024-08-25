package com.bootcamp.pragma.stockmicroservice.configuration;

import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.exceptions.*;
import com.bootcamp.pragma.stockmicroservice.domain.exception.*;
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

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Map<String, String>> handleNumberFormatException(NumberFormatException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, INVALID_NUMBER_FORMAT_MESSAGE));
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

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Map<String, String>> categoryNotFoundException(CategoryNotFoundException categoryNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, CATEGORY_NOT_FOUND));
    }

    @ExceptionHandler(BrandNotFoundException.class)
    public ResponseEntity<Map<String, String>> brandNotFoundException(BrandNotFoundException brandNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, BRAND_NOT_FOUND));
    }

    @ExceptionHandler(ArticleNameAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> articleNameAlreadyExistsException(ArticleNameAlreadyExistsException articleNameAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, ARTICLE_ALREADY_EXISTS_BRAND));
    }

    @ExceptionHandler(EmptyFieldException.class)
    public ResponseEntity<Map<String, String>> emptyFieldException(EmptyFieldException emptyFieldException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, FIELD_EMPTY_MESSAGE));
    }

    @ExceptionHandler(ExceedFieldException.class)
    public ResponseEntity<Map<String, String>> exceedFieldException(ExceedFieldException exceedFieldException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, FIELD_NAME_LENGTH_MESSAGE));
    }

    @ExceptionHandler(ExceedCategorySizeException.class)
    public ResponseEntity<Map<String, String>> exceedCategorySizeException(ExceedCategorySizeException exceedCategorySizeException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, CATEGORY_SIZE_MESSAGE));
    }

    @ExceptionHandler(NoCategoryAssociatedException.class)
    public ResponseEntity<Map<String, String>> noCategoryAssociatedException(NoCategoryAssociatedException noCategoryAssociatedException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, NO_CATEGORY_ASSOCIATED_MESSAGE));
    }

    @ExceptionHandler(NegativeNotAllowedException.class)
    public ResponseEntity<Map<String, String>> negativeNotAllowedException(NegativeNotAllowedException negativeNotAllowedException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, FIELD_NEGATIVE_VALUE_MESSAGE));
    }
}
