package com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.request;

import com.bootcamp.pragma.stockmicroservice.domain.exception.ExceedFielException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import static com.bootcamp.pragma.stockmicroservice.configuration.Constants.FIELD_EMPTY_MESSAGE;
import static com.bootcamp.pragma.stockmicroservice.configuration.Constants.FIELD_LENGTH_MESSAGE;

@Getter
public class AddBrandRequest {
    @NotNull(message = FIELD_EMPTY_MESSAGE)
    @NotBlank(message = FIELD_EMPTY_MESSAGE)
    @Size(min = 2, max = 50, message = FIELD_LENGTH_MESSAGE)
    private final String name;
    @NotNull(message = FIELD_EMPTY_MESSAGE)
    @NotBlank(message = FIELD_EMPTY_MESSAGE)
    @Size(min = 2, max = 120, message = FIELD_LENGTH_MESSAGE)
    private final String description;

    public AddBrandRequest(String name, String description) {
        this.name = (null != name) ? name.trim() : null;
        this.description = (description != null) ? description.trim() : null;
    }
}
