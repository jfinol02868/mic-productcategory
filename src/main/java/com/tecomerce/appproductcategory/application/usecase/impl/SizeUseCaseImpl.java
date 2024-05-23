package com.tecomerce.appproductcategory.application.usecase.impl;

import com.tecomerce.appproductcategory.application.usecase.SizeUseCase;
import com.tecomerce.appproductcategory.domain.entity.Size;
import com.tecomerce.appproductcategory.domain.repository.SizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SizeUseCaseImpl implements SizeUseCase {
    
    private final SizeRepository repository;

    @Override
    public Size create(Size entity) {
        return repository.create(entity);
    }

    @Override
    public List<Size> createAll(List<Size> entities) {
        return repository.createAll(entities);
    }

    @Override
    public Size update(Size entity, String id) {
        return repository.update(entity, id);
    }

    @Override
    public List<Size> updateAll(List<Size> entities) {
        return repository.updateAll(entities);
    }

    @Override
    public Size findById(String id) {
        return repository.findById(id);
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
    public List<Size> deleteAll(List<String> ids) {
        return repository.deleteAll(ids);
    }

    @Override
    public List<Size> findAllPaginated(int page, int size, String sort, String direction) {
        return repository.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public List<Size> filterColors(String id, String name, String code, String hex, String rgb, int page, int size, String direction, String... properties) {
        return repository.filterColors(id, name, code, hex, rgb, page, size, direction, properties);
    }
}
