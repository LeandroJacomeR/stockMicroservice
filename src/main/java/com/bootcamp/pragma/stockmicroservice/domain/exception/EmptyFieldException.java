package com.bootcamp.pragma.stockmicroservice.domain.exception;

public class EmptyFieldException extends RuntimeException {
    public EmptyFieldException(String message) {
        super(message);
    }
}