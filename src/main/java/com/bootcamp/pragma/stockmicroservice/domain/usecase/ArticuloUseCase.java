package com.bootcamp.pragma.stockmicroservice.domain.usecase;

import com.bootcamp.pragma.stockmicroservice.domain.api.IArticuloServicePort;
import com.bootcamp.pragma.stockmicroservice.domain.model.Articulo;
import com.bootcamp.pragma.stockmicroservice.domain.spi.IArticuloPersistencePort;

import java.util.List;

public class ArticuloUseCase implements IArticuloServicePort {

    private final IArticuloPersistencePort articuloPersistencePort;

    public ArticuloUseCase(IArticuloPersistencePort articuloPersistencePort) {
        this.articuloPersistencePort = articuloPersistencePort;
    }

    @Override
    public void saveArticulo(Articulo articulo) {
        articuloPersistencePort.saveArticulo(articulo);
    }

    @Override
    public List<Articulo> getAllArticulos() {
        return articuloPersistencePort.getAllArticulos();
    }

    @Override
    public Articulo getArticuloById(int id) {
        return articuloPersistencePort.getArticuloById(id);
    }
}
