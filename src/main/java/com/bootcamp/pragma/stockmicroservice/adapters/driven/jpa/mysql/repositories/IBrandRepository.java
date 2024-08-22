package com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.repositories;

import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.entity.BrandEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBrandRepository extends JpaRepository<BrandEntity, Long> {
    Optional<BrandEntity> findByName(String name);
    Page<BrandEntity> findAll(Pageable pageable);
}
