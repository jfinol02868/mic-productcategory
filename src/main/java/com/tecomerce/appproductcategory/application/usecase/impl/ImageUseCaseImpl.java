package com.tecomerce.appproductcategory.application.usecase.impl;

import com.tecomerce.appproductcategory.application.usecase.ImageUseCase;
import com.tecomerce.appproductcategory.domain.entity.Image;
import com.tecomerce.appproductcategory.domain.repository.ImageRepository;
import com.tecomerce.appproductcategory.domain.util.MapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ImageUseCaseImpl implements ImageUseCase {

    private final MapperUtil mapperUtil;
    private final ImageRepository repository;

    @Override
    public Image create(Image entity) {
        entity.dateOfCreation();
        return repository.create(entity);
    }

    @Override
    public List<Image> createAll(List<Image> entities) {
        entities.forEach(Image::dateOfCreation);
        return repository.createAll(entities);
    }

    @Override
    public Image update(Image entity, String id) {
        return repository.update(entity, id);
    }

    @Override
    public List<Image> updateAll(List<Image> entities) {
        return repository.updateAll(entities);
    }

    @Override
    public Image findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Image> findByIds(List<String> ids) {
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
    public List<Image> findAllPaginated(int page, int size, String sort, String direction) {
        return repository.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public List<Image> filters(String filterProperties, int page, int size, String direction, String... sortProperties) {
        Image image = (Image) mapperUtil.mappingEntity(filterProperties, Image.class);
        return repository.filters(image, page, size, direction, sortProperties);
    }
}
