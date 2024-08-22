package com.bootcamp.pragma.stockmicroservice.adapters.driving.http.handler;


import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.request.AddBrandRequest;
import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.response.BrandResponse;

import java.util.List;

public interface IBrandHandler {
    void saveBrand(AddBrandRequest brandRequest);
    BrandResponse getBrand(Long id);
    List<BrandResponse> getAllBrands(int page, String order);
}
