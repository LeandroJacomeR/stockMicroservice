package com.bootcamp.pragma.stockmicroservice.domain.api;

import com.bootcamp.pragma.stockmicroservice.domain.model.Category;

import java.util.List;

public interface ICategoryServicePort {
    void saveCategory(Category categoria);
    List<Category> getAllCategories(int page, String order);
    Category getCategoryById(Long id);
}
