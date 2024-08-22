package com.bootcamp.pragma.stockmicroservice.adapters.driving.http.mapper;

import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.request.AddBrandRequest;
import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IBrandRequestMapper {
    @Mapping(target = "id", ignore = true)
    Brand addBrandToBrand(AddBrandRequest addBrandRequest);
}
