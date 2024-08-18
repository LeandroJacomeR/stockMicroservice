package com.bootcamp.pragma.stockmicroservice.domain.api;

import com.bootcamp.pragma.stockmicroservice.domain.model.Marca;

import java.util.List;

public interface IMarcaServicePort {
    void saveMarca(Marca marca);
    List<Marca> getAllMarca();
    Marca getMarcaById(int id);
}
