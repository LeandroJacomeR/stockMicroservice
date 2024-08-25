package com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Set;

import static com.bootcamp.pragma.stockmicroservice.configuration.Constants.*;

public class AddArticleRequest {
    @NotBlank(message = FIELD_EMPTY_MESSAGE)
    @NotNull(message = FIELD_NULL_MESSAGE)
    private final String name;
    @NotBlank(message = FIELD_EMPTY_MESSAGE)
    @NotNull(message = FIELD_NULL_MESSAGE)
    private final String description;
    @NotNull(message = FIELD_NULL_MESSAGE)
    @Min(value = 1, message = FIELD_MIN_VALUE_MESSAGE)
    private final int quantity;
    @NotNull(message = FIELD_NULL_MESSAGE)
    @DecimalMin(value = "1.0", message = FIELD_MIN_VALUE_MESSAGE)
    private final BigDecimal price;
    @NotNull(message = FIELD_NULL_MESSAGE)
    private final Set<Long> categories;
    @NotNull(message = FIELD_NULL_MESSAGE)
    private final Long brand;

    public AddArticleRequest(String name, String description, int quantity, BigDecimal price, Set<Long> categories, Long brand) {
        this.name = (null != name) ? name.trim() : null;
        this.description = (description != null) ? description.trim() : null;
        this.quantity = quantity;
        this.price = price;
        this.categories = categories;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Set<Long> getCategories() {
        return categories;
    }

    public Long getBrand() {
        return brand;
    }
}
