package com.tecomerce.appproductcategory.infrastructure.bd.repository.impl;

import com.tecomerce.appproductcategory.domain.entity.Color;
import com.tecomerce.appproductcategory.domain.exception.EntityNotFoundException;
import com.tecomerce.appproductcategory.domain.repository.ColorRepository;
import com.tecomerce.appproductcategory.infrastructure.bd.document.ColorDocument;
import com.tecomerce.appproductcategory.infrastructure.bd.mapper.ColorMapper;
import com.tecomerce.appproductcategory.infrastructure.bd.repository.ColorRepositoryAdapter;
import com.tecomerce.appproductcategory.infrastructure.util.DynamicFilterMap;
import com.tecomerce.appproductcategory.infrastructure.util.IdGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
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
public class ColorRepositoryImpl implements ColorRepository {

    private final ColorMapper mapper;
    private final IdGenerator idGenerator;
    private final MongoTemplate mongoTemplate;
    private final DynamicFilterMap dynamicFilterMap;
    private final ColorRepositoryAdapter repository;

    @Override
    public Color create(Color entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(ColorDocument.class));
        return mapper.toEntity(repository.save(mapper.toDocument(entity)));
    }

    @Override
    public List<Color> createAll(List<Color> entities) {
        entities = entities.stream().peek(entity -> {
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(ColorDocument.class));
        }).collect(Collectors.toList());
        return mapper.toEntityList(repository.saveAll(mapper.toDocumentList(entities)));
    }

    @Override
    public Color update(Color entity, String id) {
        ColorDocument color = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        entity.setId(id);
        entity.setCreateAt(color.getCreateAt());
        BeanUtils.copyProperties(entity, color);
        return mapper.toEntity(repository.save(color));
    }

    @Override
    public List<Color> updateAll(List<Color> entities) {
        return entities.stream()
                .flatMap(entity -> repository.findById(entity.getId())
                        .map(existingEntity -> {
                            entity.setCreateAt(existingEntity.getCreateAt());
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
    public Color findById(String id) {
        return mapper.toEntity(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<Color> findByIds(List<String> ids) {
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
    public List<Color> findAllPaginated(int page, int size, String sort, String direction) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(dir, sort));
        Page<ColorDocument> colorPage = repository.findAll(pageRequest);
        return mapper.toEntityList(colorPage.getContent());
    }

    @Override
    public List<Color> filters(Color color, int page, int size, String direction, String... sortProperties) {
        Field[] fields = Color.class.getDeclaredFields();
        Query query = dynamicFilterMap.queryFilter(fields, color, page, size, direction, sortProperties);
        return mapper.toEntityList(mongoTemplate.find(query, ColorDocument.class));
    }
}
