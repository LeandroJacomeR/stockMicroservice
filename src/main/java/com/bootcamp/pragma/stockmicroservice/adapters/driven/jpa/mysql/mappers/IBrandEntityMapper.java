package com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.mappers;

import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.entity.BrandEntity;
import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBrandEntityMapper {
    BrandEntity toEntity(Brand brand);
    Brand toBrand(BrandEntity brandEntity);
    List<BrandEntity> toEntityList(List<Brand> brands);
}
