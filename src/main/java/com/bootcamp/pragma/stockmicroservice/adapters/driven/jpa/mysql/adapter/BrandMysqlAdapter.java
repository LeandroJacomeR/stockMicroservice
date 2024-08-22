package com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.adapter;

import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.entity.BrandEntity;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.exceptions.BrandAlreadyExistsException;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.exceptions.NoDataFoundException;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.mappers.IBrandEntityMapper;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.repositories.IBrandRepository;
import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;
import com.bootcamp.pragma.stockmicroservice.domain.spi.IBrandPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.bootcamp.pragma.stockmicroservice.configuration.Constants.MAX_PAGE_SIZE;

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
        brandRepository.save(brandEntityMapper.toEntity(brand));
    }

    @Override
    public List<Brand> getAllMarca(int page, String order) {
        Sort sort = Sort.by(Sort.Direction.fromString(order), "name");
        Pageable pagination = PageRequest.of(page, MAX_PAGE_SIZE, sort);
        List<BrandEntity> brandEntityList = brandRepository.findAll(pagination).getContent();
        if (brandEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return brandEntityMapper.toEntityList(brandEntityList);
    }

    @Override
    public Brand getMarcaById(Long id) {
        return brandEntityMapper.toBrand(brandRepository.findById(id).orElseThrow(NoDataFoundException::new));
    }
}
