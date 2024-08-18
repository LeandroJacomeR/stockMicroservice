package com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.repositories;

import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(String name);
}
