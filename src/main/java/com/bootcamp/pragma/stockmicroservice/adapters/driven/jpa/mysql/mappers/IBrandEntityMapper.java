package com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.mappers;

import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.entity.BrandEntity;
import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBrandEntityMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    BrandEntity toEntity(Brand brand);
    Brand toBrand(BrandEntity brandEntity);
    List<Brand> toEntityList(List<BrandEntity> brandEntityList);
}
