package com.bootcamp.pragma.stockmicroservice.adapters.driving.http.mapper;

import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.request.AddCategoryRequest;
import com.bootcamp.pragma.stockmicroservice.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ICategoryRequestMapper {
    @Mapping(target = "id", ignore = true)
    Category addCategoryToCategory(AddCategoryRequest addCategoryRequest);
}

