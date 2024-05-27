package com.tecomerce.appproductcategory.application.usecase.impl;

import com.tecomerce.appproductcategory.application.usecase.CategoryDetailUseCase;
import com.tecomerce.appproductcategory.application.usecase.CategoryUseCase;
import com.tecomerce.appproductcategory.domain.entity.Category;
import com.tecomerce.appproductcategory.domain.entity.CategoryDetail;
import com.tecomerce.appproductcategory.domain.repository.CategoryDetailRepository;
import com.tecomerce.appproductcategory.domain.repository.CategoryRepository;
import com.tecomerce.appproductcategory.domain.util.MapperUtil;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CategoryUseCaseImpl implements CategoryUseCase , CategoryDetailUseCase {

    private final MapperUtil mapperUtil;
    private final CategoryRepository repository;
    private final CategoryDetailRepository categoryDetailRepository;

    @Override
    public Category create(Category entity) {
        entity.dateOfCreation();
        entity.initializationOfCategories(entity.getCategories());
        entity.initializationOfProducts(entity.getProducts());
        entity.getCategories().forEach(repository::findById);
        return repository.create(entity);
    }

    @Override
    @Transactional
    public List<Category> createAll(List<Category> entities) {
        entities.forEach(entity -> {
            entity.dateOfCreation();
            entity.initializationOfCategories(entity.getCategories());
            entity.initializationOfProducts(entity.getProducts());
        });
        return repository.createAll(entities);
    }

    @Override
    public Category update(Category entity, String id) {
        return repository.update(entity, id);
    }

    @Override
    @Transactional
    public List<Category> updateAll(List<Category> entities) {
        return repository.updateAll(entities);
    }

    @Override
    public Category findById(String id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public List<Category> findByIds(List<String> ids) {
       return repository.findByIds(ids);
    }

    @Override
    public void delete(String id, boolean deleteChildren) {
        Category category = repository.findById(id);
        if(deleteChildren && Objects.nonNull(category)){
            repository.deleteAll(category.getCategories());
            repository.delete(id);
            return;
        }
        repository.delete(id);
    }

    @Override
    public void deleteAll(List<String> ids) {
        repository.deleteAll(ids);
    }

    @Override
    public List<Category> findAllPaginated(int page, int size, String sort, String direction) {
        return repository.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public List<Category> filters(String filterProperties, int page, int size, String direction, String... sortProperties) {
        Category category = (Category) mapperUtil.mappingEntity(filterProperties, Category.class);
        return repository.filters(category, page, size, direction, sortProperties);
    }

    @Override
    public CategoryDetail findCategoryDetailByCategoryId(String id) {
        return categoryDetailRepository.findCategoryDetailByCategoryId(id);
    }
}
