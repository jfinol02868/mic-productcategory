package com.tecomerce.appproductcategory.application.usecase.impl;

import com.tecomerce.appproductcategory.application.usecase.ColorUseCase;
import com.tecomerce.appproductcategory.domain.entity.Color;
import com.tecomerce.appproductcategory.domain.repository.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorUseCaseImpl implements ColorUseCase {

    private final ColorRepository repository;


    @Override
    public Color create(Color entity) {
        return repository.create(entity);
    }

    @Override
    public List<Color> createAll(List<Color> entities) {
        return repository.createAll(entities);
    }

    @Override
    public Color update(Color entity, String id) {
        return repository.update(entity, id);
    }

    @Override
    public List<Color> updateAll(List<Color> entities) {
        return repository.updateAll(entities);
    }

    @Override
    public Color findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Color> findByIds(List<String> ids) {
        return repository.findByIds(ids);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    public List<Color> deleteAll(List<String> ids) {
        return repository.deleteAll(ids);
    }

    @Override
    public List<Color> findAll(int page, int size, String sort, String direction) {
        return repository.findAll(page, size, sort, direction);
    }
}
