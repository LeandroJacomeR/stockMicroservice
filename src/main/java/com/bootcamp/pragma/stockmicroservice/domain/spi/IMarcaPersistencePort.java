package com.bootcamp.pragma.stockmicroservice.domain.spi;

import com.bootcamp.pragma.stockmicroservice.domain.model.Marca;

import java.util.List;

public interface IMarcaPersistencePort {
    void saveMarca(Marca marca);
    List<Marca> getAllMarca();
    Marca getMarcaById(int id);
}
