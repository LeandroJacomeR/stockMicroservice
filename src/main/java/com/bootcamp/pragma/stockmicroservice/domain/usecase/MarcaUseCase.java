package com.bootcamp.pragma.stockmicroservice.domain.usecase;

import com.bootcamp.pragma.stockmicroservice.domain.api.IMarcaServicePort;
import com.bootcamp.pragma.stockmicroservice.domain.model.Marca;
import com.bootcamp.pragma.stockmicroservice.domain.spi.IMarcaPersistencePort;

import java.util.List;

public class MarcaUseCase implements IMarcaServicePort {

    private final IMarcaPersistencePort marcaPersistencePort;

    public MarcaUseCase(IMarcaPersistencePort marcaPersistencePort) {
        this.marcaPersistencePort = marcaPersistencePort;
    }

    @Override
    public void saveMarca(Marca marca) {
        marcaPersistencePort.saveMarca(marca);
    }

    @Override
    public List<Marca> getAllMarca() {
        return marcaPersistencePort.getAllMarca();
    }

    @Override
    public Marca getMarcaById(int id) {
        return marcaPersistencePort.getMarcaById(id);
    }
}
