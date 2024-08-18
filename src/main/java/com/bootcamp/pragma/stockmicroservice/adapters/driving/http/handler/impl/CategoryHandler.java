package com.bootcamp.pragma.stockmicroservice.adapters.driving.http.handler.impl;

import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.request.AddCategoryRequest;
import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.response.CategoryResponse;
import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.handler.ICategoryHandler;
import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.mapper.ICategoryRequestMapper;
import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.mapper.ICategoryResponseMapper;
import com.bootcamp.pragma.stockmicroservice.domain.api.ICategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryHandler implements ICategoryHandler {

    private final ICategoryServicePort categoryServicePort;
    private final ICategoryRequestMapper categoryRequestMapper;
    private final ICategoryResponseMapper categoryResponseMapper;

    @Override
    public void saveCategory(AddCategoryRequest categoryRequest) {
        categoryServicePort.saveCategory(categoryRequestMapper.addCategoryToCategory(categoryRequest));
    }

    @Override
    public List<CategoryResponse> getCategories() {
        return categoryResponseMapper.toCategoryResponseList(categoryServicePort.getAllCategories());
    }

    @Override
    public CategoryResponse getCategory(Long id) {
        return categoryResponseMapper.toCategoryResponse(categoryServicePort.getCategoryById(id));
    }
}
