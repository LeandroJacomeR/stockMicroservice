package com.bootcamp.pragma.stockmicroservice.domain.util;

public final class DomainConstants {
    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String FIELD_EMPTY_MESSAGE = "The field cannot be empty.";
    public static final String FIELD_NAME_LENGTH_MESSAGE = "The name exceeds the maximum number of characters.";
    public static final String FIELD_NAME_NULL_MESSAGE = "The name is required.";
    public static final String FIELD_DESCRIPTION_LENGTH_MESSAGE = "The description exceeds the maximum number of characters.";
    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "The description is required.";
}
