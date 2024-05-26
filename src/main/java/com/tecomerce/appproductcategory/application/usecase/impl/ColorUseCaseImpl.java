package com.tecomerce.appproductcategory.application.usecase.impl;

import com.tecomerce.appproductcategory.application.usecase.ColorUseCase;
import com.tecomerce.appproductcategory.domain.entity.Color;
import com.tecomerce.appproductcategory.domain.entity.Image;
import com.tecomerce.appproductcategory.domain.repository.ColorRepository;
import com.tecomerce.appproductcategory.domain.util.MapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorUseCaseImpl implements ColorUseCase {

    private final MapperUtil mapperUtil;
    private final ColorRepository repository;

    @Override
    public Color create(Color entity) {
        entity.dateOfCreation();
        return repository.create(entity);
    }

    @Override
    public List<Color> createAll(List<Color> entities) {
        entities.forEach(Color::dateOfCreation);
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
    public void deleteAll(List<String> ids) {
        repository.deleteAll(ids);
    }

    @Override
    public List<Color> findAllPaginated(int page, int size, String sort, String direction) {
        return repository.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public List<Color> filters(String filterProperties, int page, int size, String direction, String... sortProperties) {
        Color color = (Color) mapperUtil.mappingEntity(filterProperties, Color.class);
        return repository.filters(color, page, size, direction, sortProperties);
    }
}
