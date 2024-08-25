package com.bootcamp.pragma.stockmicroservice.domain.spi;

import com.bootcamp.pragma.stockmicroservice.domain.model.Article;

import java.util.List;

public interface IArticlePersistencePort {
    void saveArticle(Article article);
    List<Article> getAllArticle(int page, String order, String property);
    Article getArticleById(int id);
}
