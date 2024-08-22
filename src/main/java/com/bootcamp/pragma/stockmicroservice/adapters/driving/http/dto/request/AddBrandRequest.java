package com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import static com.bootcamp.pragma.stockmicroservice.configuration.Constants.FIELD_EMPTY_MESSAGE;

@Getter
public class AddBrandRequest {
    @NotBlank(message = FIELD_EMPTY_MESSAGE)
    private final String name;
    @NotBlank(message = FIELD_EMPTY_MESSAGE)
    private final String description;

    public AddBrandRequest(String name, String description) {
        this.name = (null != name) ? name.trim() : null;
        this.description = (description != null) ? description.trim() : null;
    }
}
