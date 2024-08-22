package com.bootcamp.pragma.stockmicroservice.domain.model;

import com.bootcamp.pragma.stockmicroservice.domain.exception.EmptyFieldException;
import com.bootcamp.pragma.stockmicroservice.domain.exception.ExceedFielException;
import com.bootcamp.pragma.stockmicroservice.domain.util.DomainConstants;

import static java.util.Objects.requireNonNull;

public class Category {
    private final Long id;
    private final String name;
    private final String description;

    public Category(Long id, String name, String description) {
        if (name.trim().isEmpty()) {
            System.out.println("trim" + name.trim());
            throw new EmptyFieldException();
        }
        System.out.println("trim:" + name.trim() + ".");
        if (name.length() > 50) {
            throw new ExceedFielException();
        }
        if (description.trim().isEmpty()) {
            throw new EmptyFieldException();
        }
        if (description.length() > 90) {
            throw new ExceedFielException();
        }
        this.id = id;
        this.name = requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.description = requireNonNull(description, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
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
