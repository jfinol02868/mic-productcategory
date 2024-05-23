package com.tecomerce.appproductcategory.application.usecase.impl;

import com.tecomerce.appproductcategory.api.service.dto.enums.SortEnum;
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
    public List<Size> filterSize(String id, String name, String code, String description, String type, String size, int page, int records, String direction, String... properties) {
        return repository.filterSize(id, name, code, description, type, size, page, records, direction, properties);
    }
}
