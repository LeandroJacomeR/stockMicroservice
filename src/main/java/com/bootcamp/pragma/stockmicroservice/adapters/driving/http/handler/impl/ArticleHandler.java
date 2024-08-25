package com.bootcamp.pragma.stockmicroservice.adapters.driving.http.handler.impl;

import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.request.AddArticleRequest;
import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.response.ArticleResponse;
import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.handler.IArticleHandler;
import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.mapper.IArticleRequestMapper;
import com.bootcamp.pragma.stockmicroservice.domain.api.IArticleServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleHandler implements IArticleHandler {
    private final IArticleServicePort articleServicePort;
    private final IArticleRequestMapper articleRequestMapper;

    @Override
    public void saveArticle(AddArticleRequest addArticleRequest) {
        articleServicePort.saveArticle(articleRequestMapper.addArticleToArticle(addArticleRequest));
    }

    @Override
    public ArticleResponse getArticle(Long id) {
        return null;
    }

    @Override
    public List<ArticleResponse> getAllArticles(int page, String order, String orderProperty) {
        return List.of();
    }
}
