package com.bootcamp.pragma.stockmicroservice.domain.usecase;

import com.bootcamp.pragma.stockmicroservice.domain.api.ICategoryServicePort;
import com.bootcamp.pragma.stockmicroservice.domain.model.Category;
import com.bootcamp.pragma.stockmicroservice.domain.spi.ICategoryPersistencePort;

import java.util.List;

public class CategoriaUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoriaPersistencePort;

    public CategoriaUseCase(ICategoryPersistencePort categoriaPersistencePort) {
        this.categoriaPersistencePort = categoriaPersistencePort;
    }

    @Override
    public void saveCategory(Category categoria) {
        categoriaPersistencePort.saveCategory(categoria);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoriaPersistencePort.getAllCategory();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoriaPersistencePort.getCategoryById(id);
    }
}
