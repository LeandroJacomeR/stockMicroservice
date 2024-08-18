package com.bootcamp.pragma.stockmicroservice.domain.api;

import com.bootcamp.pragma.stockmicroservice.domain.model.Articulo;

import java.util.List;

public interface IArticuloServicePort {
    void saveArticulo(Articulo articulo);
    List<Articulo> getAllArticulos();
    Articulo getArticuloById(int id);
}
