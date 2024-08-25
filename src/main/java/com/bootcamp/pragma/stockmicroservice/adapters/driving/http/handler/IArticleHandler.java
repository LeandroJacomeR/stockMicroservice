package com.bootcamp.pragma.stockmicroservice.adapters.driving.http.handler;

import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.request.AddArticleRequest;
import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.response.ArticleResponse;

import java.util.List;

public interface IArticleHandler {
    void saveArticle(AddArticleRequest addArticleRequest);
    ArticleResponse getArticle(Long id);
    List<ArticleResponse> getAllArticles(int page, String order, String orderProperty);
}
