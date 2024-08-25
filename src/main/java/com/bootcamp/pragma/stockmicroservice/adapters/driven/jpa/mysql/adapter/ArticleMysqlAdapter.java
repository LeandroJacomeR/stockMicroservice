package com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.adapter;

import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.exceptions.ArticleNameAlreadyExistsException;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.exceptions.BrandNotFoundException;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.exceptions.CategoryNotFoundException;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.mappers.IArticleEntityMapper;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.repositories.IArticleRepository;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.repositories.IBrandRepository;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.repositories.ICategoryRepository;
import com.bootcamp.pragma.stockmicroservice.domain.model.Article;
import com.bootcamp.pragma.stockmicroservice.domain.model.Category;
import com.bootcamp.pragma.stockmicroservice.domain.spi.IArticlePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
public class ArticleMysqlAdapter implements IArticlePersistencePort {
    private final IArticleRepository articleRepository;
    private final IArticleEntityMapper articleEntityMapper;
    private final ICategoryRepository categoryRepository;
    private final IBrandRepository brandRepository;

    @Override
    public void saveArticle(Article article) {
        for (Category category : article.getCategories()) {
            boolean exists = categoryRepository.findById(category.getId()).isPresent();
            if (!exists) {
                throw new CategoryNotFoundException();
            }
        }
        // Validar la existencia de la marca
        boolean brandExists = brandRepository.findById(article.getBrand().getId()).isPresent();
        if (!brandExists) {
            throw new BrandNotFoundException();
        }

        // Verificar si el nombre del artículo ya existe con la misma marca
        boolean articleExists = articleRepository.existsByNameAndBrand_Id(article.getName(), article.getBrand().getId());
        if (articleExists) {
            throw new ArticleNameAlreadyExistsException();
        }
        articleRepository.save(articleEntityMapper.toEntity(article));
    }

    @Override
    public List<Article> getAllArticle(int page, String order, String property) {
        return List.of();
    }

    @Override
    public Article getArticleById(int id) {
        return null;
    }
}
