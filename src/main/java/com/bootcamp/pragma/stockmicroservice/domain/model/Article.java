package com.bootcamp.pragma.stockmicroservice.domain.model;

import com.bootcamp.pragma.stockmicroservice.domain.exception.ExceedCategorySizeException;
import com.bootcamp.pragma.stockmicroservice.domain.exception.NegativeNotAllowedException;
import com.bootcamp.pragma.stockmicroservice.domain.exception.NoCategoryAssociatedException;
import com.bootcamp.pragma.stockmicroservice.domain.util.DomainConstants;

import java.math.BigDecimal;
import java.util.Set;

import static java.util.Objects.requireNonNull;

public class Article {
    private final Long id;
    private final String name;
    private final String description;
    private final int quantity;
    private final BigDecimal price;

    private final Set<Category> categories;
    private final Brand brand;

    public Article(Long id, String name, String description, int quantity, BigDecimal price, Set<Category> categories, Brand brand) {
        if (categories.isEmpty()){
            throw new NoCategoryAssociatedException();
        }
        if (categories.size() > 3){
            throw new ExceedCategorySizeException();
        }
        if (quantity < 0 || price.compareTo(BigDecimal.ZERO) < 0){
            throw new NegativeNotAllowedException();
        }
        this.id = id;
        this.name = requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.description = requireNonNull(description, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        this.quantity = requireNonNull(quantity, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        this.price = requireNonNull(price, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        this.categories = requireNonNull(categories, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        this.brand = requireNonNull(brand, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }

    public Long getId() {
        return id;
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

    public Set<Category> getCategories() {
        return categories;
    }

    public Brand getBrand() {
        return brand;
    }
}
