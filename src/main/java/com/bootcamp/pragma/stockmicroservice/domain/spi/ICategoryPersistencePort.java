package com.bootcamp.pragma.stockmicroservice.domain.spi;

import com.bootcamp.pragma.stockmicroservice.domain.model.Category;

import java.util.List;

public interface ICategoryPersistencePort {
    void saveCategory(Category categoria);
    List<Category> getAllCategory(int page, String order);
    Category getCategoryById(Long id);
}
