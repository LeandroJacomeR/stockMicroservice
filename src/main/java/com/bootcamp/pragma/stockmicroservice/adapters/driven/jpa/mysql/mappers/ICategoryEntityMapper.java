package com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.mappers;

import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.bootcamp.pragma.stockmicroservice.domain.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICategoryEntityMapper {
    CategoryEntity toEntity(Category category);
    Category toCategory(CategoryEntity categoryEntity);
    List<Category> toEntityList(List<CategoryEntity> categoryEntityList);
}
