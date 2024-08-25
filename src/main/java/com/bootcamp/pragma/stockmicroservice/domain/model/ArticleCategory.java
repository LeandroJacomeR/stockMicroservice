package com.bootcamp.pragma.stockmicroservice.domain.model;

public class ArticleCategory {
    private final Long id;
    private final Article article;
    private final Category categoria;

    public ArticleCategory(Long id, Article article, Category categoria) {
        this.id = id;
        this.article = article;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public Article getArticle() {
        return article;
    }

    public Category getCategoria() {
        return categoria;
    }
}
