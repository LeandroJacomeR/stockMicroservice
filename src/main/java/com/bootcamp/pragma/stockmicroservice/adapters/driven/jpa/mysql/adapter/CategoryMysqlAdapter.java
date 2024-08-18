package com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.adapter;

import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.exceptions.CategoryAlreadyExistsException;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.exceptions.NoDataFoundException;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.mappers.ICategoryEntityMapper;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.repositories.ICategoryRepository;
import com.bootcamp.pragma.stockmicroservice.domain.model.Category;
import com.bootcamp.pragma.stockmicroservice.domain.spi.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
public class CategoryMysqlAdapter implements ICategoryPersistencePort {

    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    @Override
    public void saveCategory(Category category) {
        if (categoryRepository.findByName(category.getName()).isPresent()){
            throw new CategoryAlreadyExistsException();
        }
        categoryRepository.save(categoryEntityMapper.toEntity(category));
    }

    @Override
    public List<Category> getAllCategory() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        if (categoryEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return categoryEntityMapper.toEntityList(categoryEntityList);
    }

    @Override
    public Category getCategoryById(Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElseThrow(NoDataFoundException::new);

        // Log detallado para verificar el contenido de categoryEntity
        //System.out.println("CategoryEntity - ID: " + categoryEntity.getId() + ", Name: " + categoryEntity.getName() + ", Description: " + categoryEntity.getDescription());

        Category category = categoryEntityMapper.toCategory(categoryEntity);

        // Log detallado para verificar el contenido de category
        //System.out.println("Category - ID: " + category.getId() + ", Name: " + category.getName() + ", Description: " + category.getDescription());

        return category;
    }
}
