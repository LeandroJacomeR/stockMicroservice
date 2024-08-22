package com.bootcamp.pragma.stockmicroservice.domain.spi;

import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;

import java.util.List;

public interface IBrandPersistencePort {
    void saveMarca(Brand brand);
    List<Brand> getAllMarca(int page, String order);
    Brand getMarcaById(int id);
}
