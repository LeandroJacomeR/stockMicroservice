package com.bootcamp.pragma.stockmicroservice.domain.api;

import com.bootcamp.pragma.stockmicroservice.domain.model.Article;

import java.util.List;

public interface IArticleServicePort {
    void saveArticle(Article article);
    List<Article> getAllArticle(int page, String order, String orderProperty);
    Article getArticleById(int id);
}
