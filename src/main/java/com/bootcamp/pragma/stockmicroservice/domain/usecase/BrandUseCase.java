package com.bootcamp.pragma.stockmicroservice.domain.usecase;

import com.bootcamp.pragma.stockmicroservice.domain.api.IBrandServicePort;
import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;
import com.bootcamp.pragma.stockmicroservice.domain.spi.IBrandPersistencePort;

import java.util.List;

public class BrandUseCase implements IBrandServicePort {

    private final IBrandPersistencePort brandPersistencePort;

    public BrandUseCase(IBrandPersistencePort brandPersistencePort) {
        this.brandPersistencePort = brandPersistencePort;
    }

    @Override
    public void saveBrand(Brand brand) {
        System.out.println("usecase" + brand.getName() + brand.getDescription());
        brandPersistencePort.saveMarca(brand);
    }

    @Override
    public List<Brand> getAllBrand(int page, String order) {
        return brandPersistencePort.getAllMarca(page, order);
    }

    @Override
    public Brand getBrandById(int id) {
        return brandPersistencePort.getMarcaById(id);
    }
}
