package com.bootcamp.pragma.stockmicroservice.adapters.driving.http.handler;

import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.request.AddCategoryRequest;
import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.response.CategoryResponse;

import java.util.List;

public interface ICategoryHandler {
    void saveCategory(AddCategoryRequest category);
    List<CategoryResponse> getCategories();
    CategoryResponse getCategory(Long id);
}
