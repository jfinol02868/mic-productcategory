package com.tecomerce.appproductcategory.application.usecase.impl;

import com.tecomerce.appproductcategory.application.usecase.LocationUseCase;
import com.tecomerce.appproductcategory.domain.entity.Location;
import com.tecomerce.appproductcategory.domain.repository.LocationRepository;
import com.tecomerce.appproductcategory.domain.util.MapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationUseCaseImpl implements LocationUseCase {

    private final MapperUtil mapperUtil;
    private final LocationRepository repository;

    @Override
    public Location create(Location entity) {
        entity.dateOfCreation();
        return repository.create(entity);
    }

    @Override
    public List<Location> createAll(List<Location> entities) {
        entities.forEach(Location::dateOfCreation);
        return repository.createAll(entities);
    }

    @Override
    public Location update(Location entity, String id) {
        return repository.update(entity, id);
    }

    @Override
    public List<Location> updateAll(List<Location> entities) {
        return repository.updateAll(entities);
    }

    @Override
    public Location findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Location> findByIds(List<String> ids) {
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
    public List<Location> findAllPaginated(int page, int size, String sort, String direction) {
        return repository.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public List<Location> filterColors(String id, String name, String code, String hex, String rgb, int page, int size, String direction, String... properties) {
        return repository.filterColors(id, name, code, hex, rgb, page, size, direction, properties);
    }

    @Override
    public List<Location> filters(String filterProperties, int page, int size, String direction, String... sortProperties) {
        Location location = (Location) mapperUtil.mappingEntity(filterProperties, Location.class);
        return repository.filters(location, page, size, direction, sortProperties);
    }
}
