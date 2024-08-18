package com.bootcamp.pragma.stockmicroservice.domain.spi;

import com.bootcamp.pragma.stockmicroservice.domain.model.Articulo;

import java.util.List;

public interface IArticuloPersistencePort {
    void saveArticulo(Articulo articulo);
    List<Articulo> getAllArticulos();
    Articulo getArticuloById(int id);
}
