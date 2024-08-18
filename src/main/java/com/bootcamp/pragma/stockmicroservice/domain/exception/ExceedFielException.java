package com.bootcamp.pragma.stockmicroservice.domain.exception;

public class ExceedFielException extends RuntimeException {
    public ExceedFielException(String message) {
        super(message);
    }
}
