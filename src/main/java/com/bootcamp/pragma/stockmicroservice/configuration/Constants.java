package com.bootcamp.pragma.stockmicroservice.configuration;

public final class Constants {
    private Constants() {
        throw new IllegalStateException("Utility class");
    }
    public static final int MAX_PAGE_SIZE = 2;
    public static final String RESPONSE_MESSAGE_KEY = "message";
    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";
    public static final String CATEGORY_CREATED_MESSAGE = "Category created successfully";
    public static final String CATEGORY_ALREADY_EXISTS_MESSAGE = "A category already exists";
    public static final String CATEGORY_NOT_FOUND_MESSAGE = "No category found";
    public static final String NO_DATA_FOUND_MESSAGE = "No data found for the requested petition";
    public static final String FIELD_EMPTY_MESSAGE = "The field cannot be empty.";
}
