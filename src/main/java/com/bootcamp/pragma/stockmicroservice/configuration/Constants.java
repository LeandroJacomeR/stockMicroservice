package com.bootcamp.pragma.stockmicroservice.configuration;

public final class Constants {
    private Constants() {
        throw new IllegalStateException("Utility class");
    }
    public static final int MAX_PAGE_SIZE = 4;
    public static final String HTTP_CODE_OK = "200";
    public static final String HTTP_CODE_CREATED = "201";
    public static final String HTTP_CODE_CONFLICT = "409";
    public static final String HTTP_NOT_FOUND = "404";
    public static final String MEDIA_TYPE_JSON = "application/json";
    public static final String SCHEMA_COMPONENTS_MAP = "#/components/schemas/Map";
    public static final String SCHEMA_COMPONENTS_ERROR = "#/components/schemas/Error";
    public static final String PARAM_VALUE_PAGE = "page";
    public static final String PARAM_DEFAULT_VALUE_PAGE = "0";
    public static final String PARAM_VALUE_ORDER = "order";
    public static final String PARAM_DEFAULT_VALUE_ORDER = "asc";
    public static final String RESPONSE_MESSAGE_KEY = "message";
    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";
    public static final String CATEGORY_CREATED_MESSAGE = "Category created successfully.";
    public static final String BRAND_CREATED_MESSAGE = "Brand created successfully.";
    public static final String ARTICLE_CREATED_MESSAGE = "Article created successfully.";
    public static final String CATEGORY_ALREADY_EXISTS_MESSAGE = "A category already exists.";
    public static final String NO_CATEGORY_ASSOCIATED_MESSAGE = "Must have at least one category.";
    public static final String CATEGORY_SIZE_MESSAGE = "Exceeds category size.";
    public static final String BRAND_ALREADY_EXISTS_MESSAGE = "A brand already exists.";
    public static final String FIELD_LENGTH_MESSAGE = "The field does not have the corresponding character size.";
    public static final String NO_DATA_FOUND_MESSAGE = "No data found for the requested petition.";
    public static final String FIELD_EMPTY_MESSAGE = "The field cannot be empty.";
    public static final String FIELD_NULL_MESSAGE = "The field cannot be null.";
    public static final String FIELD_MIN_VALUE_MESSAGE = "The field must be greater than 0.";
    public static final String FIELD_NEGATIVE_VALUE_MESSAGE = "The field cannot be a negative number.";
    public static final String INVALID_NUMBER_FORMAT_MESSAGE = "Invalid number format.";
    public static final String NO_DATA_FOUND = "No data found";
    public static final String ADD_NEW_ARTICLE = "Add a new article";
    public static final String ARTICLE_CREATED = "Article created";
    public static final String ARTICLE_ALREADY_EXISTS = "Article already exists";
    public static final String ARTICLE_ALREADY_EXISTS_BRAND = "Article already exists with this brand";
    public static final String ADD_NEW_BRAND = "Add a new brand";
    public static final String BRAND_CREATED = "Brand created";
    public static final String BRAND_ALREADY_EXISTS = "Brand already exists";
    public static final String BRAND_GET_ALL = "Get all the brands";
    public static final String BRAND_GET = "Get a brand";
    public static final String BRAND_ALL_RETURNED = "All brands returned";
    public static final String BRAND_RETURNED = "Brand returned";
    public static final String BRAND_NOT_FOUND = "Brand not found";

    public static final String ADD_NEW_CATEGORY = "Add a new category";
    public static final String CATEGORY_CREATED = "Category created";
    public static final String CATEGORY_ALREADY_EXISTS = "Category already exists";
    public static final String CATEGORY_GET_ALL = "Get all the categories";
    public static final String CATEGORY_GET = "Get a category";
    public static final String CATEGORY_ALL_RETURNED = "All categories returned";
    public static final String CATEGORY_RETURNED = "Category returned";
    public static final String CATEGORY_NOT_FOUND = "Category not found";

    public static final String SWAGGER_TITLE_MESSAGE = "Stock API Pragma Bootcamp";
    public static final String SWAGGER_DESCRIPTION_MESSAGE = "Stock microservice";
    public static final String SWAGGER_VERSION_MESSAGE = "1.0.0";
    public static final String SWAGGER_LICENSE_NAME_MESSAGE = "Apache 2.0";
    public static final String SWAGGER_LICENSE_URL_MESSAGE = "http://springdoc.org";
    public static final String SWAGGER_TERMS_OF_SERVICE_MESSAGE = "http://swagger.io/terms/";
}
