package com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.adapter;

import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.exceptions.CategoryAlreadyExistsException;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.exceptions.NoDataFoundException;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.mappers.ICategoryEntityMapper;
import com.bootcamp.pragma.stockmicroservice.adapters.driven.jpa.mysql.repositories.ICategoryRepository;
import com.bootcamp.pragma.stockmicroservice.domain.model.Category;
import com.bootcamp.pragma.stockmicroservice.domain.spi.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.bootcamp.pragma.stockmicroservice.configuration.Constants.MAX_PAGE_SIZE;

@RequiredArgsConstructor
@Transactional
public class CategoryMysqlAdapter implements ICategoryPersistencePort {

    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    @Override
    public void saveCategory(Category category) {
        System.out.println(category.getDescription());
        if (categoryRepository.findByName(category.getName()).isPresent()){
            throw new CategoryAlreadyExistsException();
        }
        categoryRepository.save(categoryEntityMapper.toEntity(category));
    }

    @Override
    public List<Category> getAllCategory(int page, String order) {
        Sort sort = Sort.by(Sort.Direction.fromString(order), "name");
        Pageable pagination = PageRequest.of(page, MAX_PAGE_SIZE, sort);
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll(pagination).getContent();
        if (categoryEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return categoryEntityMapper.toEntityList(categoryEntityList);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryEntityMapper.toCategory(categoryRepository.findById(id).orElseThrow(NoDataFoundException::new));
    }
}
