package com.bootcamp.pragma.stockmicroservice.adapters.driving.http.mapper;

import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.request.AddArticleRequest;
import com.bootcamp.pragma.stockmicroservice.domain.model.Article;
import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;
import com.bootcamp.pragma.stockmicroservice.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface IArticleRequestMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "categories", source = "categories", qualifiedByName = "toCategorySet")
    @Mapping(target = "brand", source = "brand", qualifiedByName = "toBrand")
    Article addArticleToArticle(AddArticleRequest addArticleRequest);

    @Named("toCategorySet")
    default Set<Category> toCategorySet(Set<Long> categoryIds) {
        return categoryIds.stream()
                .map(id -> new Category(id, null, null))
                .collect(Collectors.toSet());
    }

    @Named("toBrand")
    default Brand toBrand(Long brandId) {
        return new Brand(brandId, null, null);
    }
}
