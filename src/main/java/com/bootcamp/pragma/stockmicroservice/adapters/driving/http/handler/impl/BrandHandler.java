package com.bootcamp.pragma.stockmicroservice.adapters.driving.http.handler.impl;

import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.request.AddBrandRequest;
import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.response.BrandResponse;
import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.handler.IBrandHandler;
import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.mapper.IBrandRequestMapper;
import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.mapper.IBrandResponseMapper;
import com.bootcamp.pragma.stockmicroservice.domain.api.IBrandServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandHandler implements IBrandHandler {

    private final IBrandServicePort brandServicePort;
    private final IBrandRequestMapper brandRequestMapper;
    private final IBrandResponseMapper brandResponseMapper;

    @Override
    public void saveBrand(AddBrandRequest brandRequest) {
        brandServicePort.saveBrand(brandRequestMapper.addBrandToBrand(brandRequest));
    }

    @Override
    public BrandResponse getBrand(Long id) {
        return null;
    }

    @Override
    public List<BrandResponse> getAllBrands(int page, String order) {
        return List.of();
    }
}
