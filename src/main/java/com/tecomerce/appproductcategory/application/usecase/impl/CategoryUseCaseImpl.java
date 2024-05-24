package com.tecomerce.appproductcategory.application.usecase.impl;

import com.tecomerce.appproductcategory.application.usecase.CategoryUseCase;
import com.tecomerce.appproductcategory.domain.entity.Category;
import com.tecomerce.appproductcategory.domain.repository.CategoryRepository;
import com.tecomerce.appproductcategory.domain.util.MapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryUseCaseImpl implements CategoryUseCase {

    private final MapperUtil mapperUtil;
    private final CategoryRepository repository;

    @Override
    public Category create(Category entity) {
        entity.dateOfCreation();
        return repository.create(entity);
    }

    @Override
    public List<Category> createAll(List<Category> entities) {
        entities.forEach(Category::dateOfCreation);
        return repository.createAll(entities);
    }

    @Override
    public Category update(Category entity, String id) {
        return repository.update(entity, id);
    }

    @Override
    public List<Category> updateAll(List<Category> entities) {
        return repository.updateAll(entities);
    }

    @Override
    public Category findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Category> findByIds(List<String> ids) {
       return repository.findByIds(ids);
    }

    @Override
    public void delete(String id) {
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
    public List<Category> filterColors(String id, String name, String code, String hex, String rgb, int page, int size, String direction, String... properties) {
        return repository.filterColors(id, name, code, hex, rgb, page, size, direction, properties);
    }

    @Override
    public List<Category> filters(String filterProperties, int page, int size, String direction, String... sortProperties) {
        Category category = (Category) mapperUtil.mappingEntity(filterProperties, Category.class);
        return repository.filters(category, page, size, direction, sortProperties);
    }
}
