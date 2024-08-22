package com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.adapter;

import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.exceptions.BrandAlreadyExistsException;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.mappers.IBrandEntityMapper;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.repositories.IBrandRepository;
import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;
import com.bootcamp.pragma.stockmicroservice.domain.spi.IBrandPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
public class BrandMysqlAdapter implements IBrandPersistencePort {

    private final IBrandRepository brandRepository;
    private final IBrandEntityMapper brandEntityMapper;

    @Override
    public void saveMarca(Brand brand) {
        if (brandRepository.findByName(brand.getName()).isPresent()) {
            throw new BrandAlreadyExistsException();
        }
        System.out.println("adapter" + brand.getName() + brand.getDescription());
        System.out.println("adapter mapper" + brandEntityMapper.toEntity(brand).getName());
        brandRepository.save(brandEntityMapper.toEntity(brand));
    }

    @Override
    public List<Brand> getAllMarca(int page, String order) {
        return List.of();
    }

    @Override
    public Brand getMarcaById(int id) {
        return null;
    }
}
