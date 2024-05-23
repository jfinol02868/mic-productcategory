package com.tecomerce.appproductcategory.infrastructure.bd.repository.impl;

import com.tecomerce.appproductcategory.domain.entity.Color;
import com.tecomerce.appproductcategory.domain.exception.EntityNotFoundException;
import com.tecomerce.appproductcategory.domain.repository.ColorRepository;
import com.tecomerce.appproductcategory.infrastructure.bd.document.ColorDocument;
import com.tecomerce.appproductcategory.infrastructure.bd.mapper.ColorMapper;
import com.tecomerce.appproductcategory.infrastructure.bd.repository.ColorRepositoryAdapter;
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
    private final ColorRepositoryAdapter cRepository;

    @Override
    public Color create(Color entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(ColorDocument.class));
        return mapper.toEntity(cRepository.save(mapper.toDocument(entity)));
    }

    @Override
    public List<Color> createAll(List<Color> entities) {
        entities = entities.stream().peek(entity -> {
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(ColorDocument.class));
        }).collect(Collectors.toList());
        return mapper.toEntityList(cRepository.saveAll(mapper.toDocumentList(entities)));
    }

    @Override
    public Color update(Color entity, String id) {
        ColorDocument color = cRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        entity.setId(id);
        BeanUtils.copyProperties(entity, color);
        return mapper.toEntity(cRepository.save(color));
    }

    @Override
    public List<Color> updateAll(List<Color> entities) {
        return entities.stream()
                .flatMap(entity -> cRepository.findById(entity.getId())
                        .map(existingEntity -> {
                            BeanUtils.copyProperties(entity, existingEntity);
                            return Stream.of(mapper.toEntity(cRepository.save(existingEntity)));
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
        return mapper.toEntity(cRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<Color> findByIds(List<String> ids) {
        return mapper.toEntityList(cRepository.findAllById(ids));
    }

    @Override
    public void delete(String id) {
        this.findById(id);
        cRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<String> ids) {
        cRepository.deleteAllById(ids);
    }

    @Override
    public List<Color> findAllPaginated(int page, int size, String sort, String direction) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(dir, sort));
        Page<ColorDocument> colorPage = cRepository.findAll(pageRequest);
        return mapper.toEntityList(colorPage.getContent());
    }

    @Override
    public List<Color> filterColors(String id, String name, String code, String hex, String rgb, int page, int size, String direction, String... properties) {
        Query query = new Query();

        if (Objects.nonNull(id)) query.addCriteria(Criteria.where("id").is(id));
        if (Objects.nonNull(name)) query.addCriteria(Criteria.where("name").is(name));
        if (Objects.nonNull(code)) query.addCriteria(Criteria.where("code").is(code));
        if (Objects.nonNull(hex)) query.addCriteria(Criteria.where("hex").is(hex));
        if (Objects.nonNull(rgb))  query.addCriteria(Criteria.where("rgb").is(rgb));

        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageable = PageRequest.of(page, size, Sort.by(dir, properties));
        query.with(pageable);

        return mapper.toEntityList(mongoTemplate.find(query, ColorDocument.class));
    }
}
