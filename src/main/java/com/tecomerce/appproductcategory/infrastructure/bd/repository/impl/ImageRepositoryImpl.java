package com.tecomerce.appproductcategory.infrastructure.bd.repository.impl;

import com.tecomerce.appproductcategory.domain.entity.Image;
import com.tecomerce.appproductcategory.domain.exception.EntityNotFoundException;
import com.tecomerce.appproductcategory.domain.repository.ImageRepository;
import com.tecomerce.appproductcategory.infrastructure.bd.document.ImagesDocuments;
import com.tecomerce.appproductcategory.infrastructure.bd.mapper.ImageMapper;
import com.tecomerce.appproductcategory.infrastructure.bd.repository.ImageRepositoryAdapter;
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
public class ImageRepositoryImpl implements ImageRepository {


    private final ImageMapper mapper;
    private final IdGenerator idGenerator;
    private final MongoTemplate mongoTemplate;
    private final DynamicFilterMap dynamicFilterMap;
    private final ImageRepositoryAdapter repository;

    @Override
    public Image create(Image entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(ImagesDocuments.class));
        entity.dateOfCreation();
        return mapper.toEntity(repository.save(mapper.toDocument(entity)));
    }

    @Override
    public List<Image> createAll(List<Image> entities) {
        entities = entities.stream().peek(entity -> {
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(ImagesDocuments.class));
        }).collect(Collectors.toList());
        return mapper.toEntityList(repository.saveAll(mapper.toDocumentList(entities)));
    }

    @Override
    public Image update(Image entity, String id) {
        ImagesDocuments image = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        entity.setId(id);
        BeanUtils.copyProperties(entity, image);
        return mapper.toEntity(repository.save(image));
    }

    @Override
    public List<Image> updateAll(List<Image> entities) {
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
    public Image findById(String s) {
        return mapper.toEntity(repository.findById(s).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<Image> findByIds(List<String> ids) {
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
    public List<Image> findAllPaginated(int page, int size, String sort, String direction) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(dir, sort));
        Page<ImagesDocuments> image = repository.findAll(pageRequest);
        return mapper.toEntityList(image.getContent());
    }

    @Override
    public List<Image> filters(Image image, int page, int size, String direction, String... sortProperties) {
        Field[] fields = Image.class.getDeclaredFields();
        Query query = dynamicFilterMap.queryFilter(fields, image, page, size, direction, sortProperties);
        return mapper.toEntityList(mongoTemplate.find(query, ImagesDocuments.class));
    }
}
