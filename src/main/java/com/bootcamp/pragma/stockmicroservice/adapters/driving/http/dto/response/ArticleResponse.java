package com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.response;

import java.math.BigDecimal;

public class ArticleResponse {
    private Long id;
    private String name;
    private String description;
    private int quantity;
    private BigDecimal price;

    public ArticleResponse(Long id, String name, String description, int quantity, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
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
}
