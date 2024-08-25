package com.bootcamp.pragma.stockmicroservice.domain.usecase;

import com.bootcamp.pragma.stockmicroservice.domain.api.IArticleServicePort;
import com.bootcamp.pragma.stockmicroservice.domain.model.Article;
import com.bootcamp.pragma.stockmicroservice.domain.spi.IArticlePersistencePort;

import java.util.List;

public class ArticleUseCase implements IArticleServicePort {

    private final IArticlePersistencePort articlePersistencePort;

    public ArticleUseCase(IArticlePersistencePort articlePersistencePort) {
        this.articlePersistencePort = articlePersistencePort;
    }

    @Override
    public void saveArticle(Article article) {
        articlePersistencePort.saveArticle(article);
    }

    @Override
    public List<Article> getAllArticle(int page, String order, String orderProperty) {
        return articlePersistencePort.getAllArticle(page, order, orderProperty);
    }

    @Override
    public Article getArticleById(int id) {
        return articlePersistencePort.getArticleById(id);
    }
}
