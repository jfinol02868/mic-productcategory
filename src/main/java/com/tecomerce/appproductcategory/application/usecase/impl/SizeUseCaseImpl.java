package com.tecomerce.appproductcategory.application.usecase.impl;

import com.tecomerce.appproductcategory.application.usecase.SizeUseCase;
import com.tecomerce.appproductcategory.domain.entity.Size;
import com.tecomerce.appproductcategory.domain.repository.SizeRepository;
import com.tecomerce.appproductcategory.domain.util.MapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SizeUseCaseImpl implements SizeUseCase {

    private final MapperUtil mapperUtil;
    private final SizeRepository repository;

    @Override
    public Size create(Size entity) {
        entity.dateOfCreation();
        return repository.create(entity);
    }

    @Override
    public List<Size> createAll(List<Size> entities) {
        entities.forEach(Size::dateOfCreation);
        return repository.createAll(entities);
    }

    @Override
    public Size update(Size entity, String s) {
        return repository.update(entity, s);
    }

    @Override
    public List<Size> updateAll(List<Size> entities) {
        return repository.updateAll(entities);
    }

    @Override
    public Size findById(String s) {
        return repository.findById(s);
    }

    @Override
    public List<Size> findByIds(List<String> id) {
        return repository.findByIds(id);
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
    public List<Size> findAllPaginated(int page, int size, String sort, String direction) {
        return repository.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public List<Size> filters(String filterProperties, int page, int size, String direction, String... sortProperties) {
        Size entity = (Size) mapperUtil.mappingEntity(filterProperties, Size.class);
        return repository.filters(entity, page, size, direction, sortProperties);
    }
}
