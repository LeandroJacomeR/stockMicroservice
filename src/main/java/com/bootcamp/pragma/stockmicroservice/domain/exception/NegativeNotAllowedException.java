package com.bootcamp.pragma.stockmicroservice.domain.exception;

public class NegativeNotAllowedException extends RuntimeException{
    public NegativeNotAllowedException(String message) {
        super(message);
    }
}
