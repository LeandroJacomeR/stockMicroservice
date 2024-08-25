package com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.mappers;

import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.entity.ArticleEntity;
import com.bootcamp.pragma.stockmicroservice.domain.model.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IArticleEntityMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "categories", target = "categories")
    @Mapping(source = "brand", target = "brand")
    ArticleEntity toEntity(Article article);
    Article toArticle(ArticleEntity articleEntity);
    List<Article> toEntityList(List<ArticleEntity> articleEntities);
}
