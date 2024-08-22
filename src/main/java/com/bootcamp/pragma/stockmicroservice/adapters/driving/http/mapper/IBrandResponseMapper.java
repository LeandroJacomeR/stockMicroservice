package com.bootcamp.pragma.stockmicroservice.adapters.driving.http.mapper;

import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.response.BrandResponse;
import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBrandResponseMapper {
    BrandResponse toBrandResponse(Brand brand);
    List<BrandResponse> toBrandResponseList(List<Brand> brands);
}
