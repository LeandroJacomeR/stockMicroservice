package com.bootcamp.pragma.stockmicroservice.configuration;

import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.adapter.ArticleMysqlAdapter;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.adapter.BrandMysqlAdapter;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.adapter.CategoryMysqlAdapter;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.mappers.IArticleEntityMapper;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.mappers.IBrandEntityMapper;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.mappers.ICategoryEntityMapper;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.repositories.IArticleRepository;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.repositories.IBrandRepository;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.repositories.ICategoryRepository;
import com.bootcamp.pragma.stockmicroservice.domain.api.IArticleServicePort;
import com.bootcamp.pragma.stockmicroservice.domain.api.IBrandServicePort;
import com.bootcamp.pragma.stockmicroservice.domain.api.ICategoryServicePort;
import com.bootcamp.pragma.stockmicroservice.domain.spi.IArticlePersistencePort;
import com.bootcamp.pragma.stockmicroservice.domain.spi.IBrandPersistencePort;
import com.bootcamp.pragma.stockmicroservice.domain.spi.ICategoryPersistencePort;
import com.bootcamp.pragma.stockmicroservice.domain.usecase.ArticleUseCase;
import com.bootcamp.pragma.stockmicroservice.domain.usecase.BrandUseCase;
import com.bootcamp.pragma.stockmicroservice.domain.usecase.CategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeansConfiguration {
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    private final IBrandRepository brandRepository;
    private final IBrandEntityMapper brandEntityMapper;

    private final IArticleRepository articleRepository;
    private final IArticleEntityMapper articleEntityMapper;

    @Bean
    public ICategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }
    @Bean
    public ICategoryPersistencePort categoryPersistencePort(){
        return new CategoryMysqlAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public IBrandServicePort brandServicePort() {
        return new BrandUseCase(brandPersistencePort());
    }
    @Bean
    public IBrandPersistencePort brandPersistencePort() {
        return new BrandMysqlAdapter(brandRepository, brandEntityMapper);
    }

    @Bean
    public IArticleServicePort articleServicePort(){
        return new ArticleUseCase(articlePersistencePort());
    }
    @Bean
    public IArticlePersistencePort articlePersistencePort() {
        return new ArticleMysqlAdapter(articleRepository, articleEntityMapper, categoryRepository, brandRepository);
    }
}
