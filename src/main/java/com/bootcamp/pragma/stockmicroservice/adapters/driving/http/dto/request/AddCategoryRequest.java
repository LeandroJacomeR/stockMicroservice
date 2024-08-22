package com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.request;

import lombok.Getter;

@Getter
public class AddCategoryRequest {
    private final String name;
    private final String description;


    public AddCategoryRequest(String name, String description) {
        this.name = (null != name) ? name.trim() : null;
        this.description = (description != null) ? description.trim() : null;
    }
}
