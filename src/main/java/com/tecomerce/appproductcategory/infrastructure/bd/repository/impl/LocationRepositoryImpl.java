package com.tecomerce.appproductcategory.infrastructure.bd.repository.impl;


import com.tecomerce.appproductcategory.domain.entity.Location;
import com.tecomerce.appproductcategory.domain.exception.EntityNotFoundException;
import com.tecomerce.appproductcategory.domain.repository.LocationRepository;
import com.tecomerce.appproductcategory.infrastructure.bd.document.LocationDocument;
import com.tecomerce.appproductcategory.infrastructure.bd.mapper.LocationMapper;
import com.tecomerce.appproductcategory.infrastructure.bd.repository.LocationRepositoryAdapter;
import com.tecomerce.appproductcategory.infrastructure.util.DynamicFilterMap;
import com.tecomerce.appproductcategory.infrastructure.util.IdGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log4j2
@Repository
@AllArgsConstructor
public class LocationRepositoryImpl implements LocationRepository {


    private final LocationMapper mapper;
    private final IdGenerator idGenerator;
    private final MongoTemplate mongoTemplate;
    private final DynamicFilterMap dynamicFilterMap;
    private final LocationRepositoryAdapter repository;

    @Override
    public Location create(Location entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(LocationDocument.class));
        entity.dateOfCreation();
        return mapper.toEntity(repository.save(mapper.toDocument(entity)));
    }

    @Override
    public List<Location> createAll(List<Location> entities) {
        entities = entities.stream().peek(entity -> {
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(LocationDocument.class));
        }).collect(Collectors.toList());
        return mapper.toEntityList(repository.saveAll(mapper.toDocumentList(entities)));
    }

    @Override
    public Location update(Location entity, String id) {
        LocationDocument Location = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        entity.setId(id);
        BeanUtils.copyProperties(entity, Location);
        return mapper.toEntity(repository.save(Location));
    }

    @Override
    public List<Location> updateAll(List<Location> entities) {
        return entities.stream()
                .flatMap(entity -> repository.findById(entity.getId())
                        .map(existingEntity -> {
                            BeanUtils.copyProperties(entity, existingEntity);
                            return Stream.of(mapper.toEntity(repository.save(existingEntity)));
                        })
                        .orElseGet(() -> {
                            log.info("Entity not found with ID: " + entity.getId());
                            return Stream.empty();
                        })
                )
                .collect(Collectors.toList());
    }

    @Override
    public Location findById(String s) {
        return mapper.toEntity(repository.findById(s).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<Location> findByIds(List<String> ids) {
        return mapper.toEntityList(repository.findAllById(ids));
    }

    @Override
    public void delete(String id) {
        this.findById(id);
        repository.deleteById(id);
    }

    @Override
    public void deleteAll(List<String> ids) {
        repository.deleteAllById(ids);
    }

    @Override
    public List<Location> findAllPaginated(int page, int size, String sort, String direction) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(dir, sort));
        Page<LocationDocument> location = repository.findAll(pageRequest);
        return mapper.toEntityList(location.getContent());
    }

    @Override
    public List<Location> filters(Location location, int page, int size, String direction, String... sortProperties) {
        Field[] fields = Location.class.getDeclaredFields();
        Query query = dynamicFilterMap.queryFilter(fields, location, page, size, direction, sortProperties);
        return mapper.toEntityList(mongoTemplate.find(query, LocationDocument.class));
    }
}
