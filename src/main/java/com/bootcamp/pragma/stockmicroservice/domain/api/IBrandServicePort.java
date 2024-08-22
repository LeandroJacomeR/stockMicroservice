package com.bootcamp.pragma.stockmicroservice.domain.api;

import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;

import java.util.List;

public interface IBrandServicePort {
    void saveBrand(Brand brand);
    List<Brand> getAllBrand(int page, String order);
    Brand getBrandById(int id);
}
