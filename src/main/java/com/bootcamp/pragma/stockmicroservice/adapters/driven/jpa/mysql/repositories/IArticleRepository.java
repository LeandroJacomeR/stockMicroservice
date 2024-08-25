package com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.repositories;

import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.entity.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IArticleRepository extends JpaRepository<ArticleEntity, Long> {
    Optional<ArticleEntity> findByName(String name);
    Page<ArticleEntity> findAll(Pageable pageable);
    boolean existsByNameAndBrand_Id(String name, Long brand);
}
