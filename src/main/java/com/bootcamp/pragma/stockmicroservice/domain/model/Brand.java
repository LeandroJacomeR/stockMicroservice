package com.bootcamp.pragma.stockmicroservice.domain.model;

import com.bootcamp.pragma.stockmicroservice.domain.exception.EmptyFieldException;
import com.bootcamp.pragma.stockmicroservice.domain.exception.ExceedFieldException;

public class Brand {
    private final Long id;
    private final String name;
    private final String description;

    public Brand(Long id, String name, String description) {
        if (name != null && name.trim().isEmpty()) {
            throw new EmptyFieldException();
        }
        if (name != null && name.length() > 50) {
            throw new ExceedFieldException();
        }
        if (description != null && description.trim().isEmpty()) {
            throw new EmptyFieldException();
        }
        if (description != null && description.length() > 90) {
            throw new ExceedFieldException();
        }
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
