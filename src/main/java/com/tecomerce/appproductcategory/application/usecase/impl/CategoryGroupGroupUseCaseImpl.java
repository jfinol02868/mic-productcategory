package com.tecomerce.appproductcategory.application.usecase.impl;

import com.tecomerce.appproductcategory.application.usecase.CategoryGroupDetailUseCase;
import com.tecomerce.appproductcategory.application.usecase.CategoryGroupUseCase;
import com.tecomerce.appproductcategory.domain.entity.CategoryGroup;
import com.tecomerce.appproductcategory.domain.entity.CategoryGroupDetail;
import com.tecomerce.appproductcategory.domain.repository.CategoryGroupDetailRepository;
import com.tecomerce.appproductcategory.domain.repository.CategoryGroupRepository;
import com.tecomerce.appproductcategory.domain.util.MapperUtil;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryGroupGroupUseCaseImpl implements CategoryGroupUseCase, CategoryGroupDetailUseCase {

    private final MapperUtil mapperUtil;
    private final CategoryGroupRepository repository;
    private final CategoryGroupDetailRepository cGRepository;

    @Override
    public CategoryGroup create(CategoryGroup entity) {
        entity.dateOfCreation();
        return repository.create(entity);
    }

    @Override
    @Transactional
    public List<CategoryGroup> createAll(List<CategoryGroup> entities) {
        entities.forEach(CategoryGroup::dateOfCreation);
        return repository.createAll(entities);
    }

    @Override
    public CategoryGroup update(CategoryGroup entity, String id) {
        return repository.update(entity, id);
    }

    @Override
    @Transactional
    public List<CategoryGroup> updateAll(List<CategoryGroup> entities) {
        return repository.updateAll(entities);
    }

    @Override
    public CategoryGroup findById(String id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public List<CategoryGroup> findByIds(List<String> ids) {
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
    public List<CategoryGroup> findAllPaginated(int page, int size, String sort, String direction) {
        return repository.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public List<CategoryGroup> filters(String filterProperties, int page, int size, String direction, String... sortProperties) {
        CategoryGroup CategoryGroup = (CategoryGroup) mapperUtil.mappingEntity(filterProperties, CategoryGroup.class);
        return repository.filters(CategoryGroup, page, size, direction, sortProperties);
    }

    @Override
    public CategoryGroupDetail findCategoryGroupDetailById(String categoryId) {
        return cGRepository.findCategoryGroupDetailById(categoryId);
    }
}
