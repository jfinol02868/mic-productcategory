package com.tecomerce.appproductcategory.infrastructure.bd.repository.impl;

import com.tecomerce.appproductcategory.domain.entity.Color;
import com.tecomerce.appproductcategory.domain.entity.Size;
import com.tecomerce.appproductcategory.domain.exception.EntityNotFoundException;
import com.tecomerce.appproductcategory.domain.repository.SizeRepository;
import com.tecomerce.appproductcategory.infrastructure.bd.document.ColorDocument;
import com.tecomerce.appproductcategory.infrastructure.bd.document.SizeDocument;
import com.tecomerce.appproductcategory.infrastructure.bd.mapper.SizeMapper;
import com.tecomerce.appproductcategory.infrastructure.bd.repository.SizeRepositoryAdapter;
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
public class SizeRepositoryImpl implements SizeRepository {

    private final SizeMapper mapper;
    private final IdGenerator idGenerator;
    private final MongoTemplate mongoTemplate;
    private final SizeRepositoryAdapter repository;

    @Override
    public Size create(Size entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(ColorDocument.class));
        return mapper.toEntity(repository.save(mapper.toDocument(entity)));
    }

    @Override
    public List<Size> createAll(List<Size> entities) {
        entities = entities.stream().peek(entity -> {
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(SizeDocument.class));
        }).collect(Collectors.toList());
        return mapper.toEntityList(repository.saveAll(mapper.toDocumentList(entities)));
    }

    @Override
    public Size update(Size entity, String id) {
        SizeDocument document = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        entity.setId(id);
        BeanUtils.copyProperties(entity, document);
        return mapper.toEntity(repository.save(document));
    }

    @Override
    public List<Size> updateAll(List<Size> entities) {
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
    public Size findById(String id) {
        return mapper.toEntity(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<Size> findByIds(List<String> ids) {
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
    public List<Size> findAllPaginated(int page, int size, String sort, String direction) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(dir, sort));
        Page<SizeDocument> colorPage = repository.findAll(pageRequest);
        return mapper.toEntityList(colorPage.getContent());
    }

    @Override
    public List<Size> filters(Size filterProperties, int page, int size, String direction, String... sortProperties) {
        Query query = new Query();
        Field[] fields = Color.class.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(filterProperties);
                if (Objects.nonNull(value)) query.addCriteria(Criteria.where(field.getName()).is(value));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageable = PageRequest.of(page, size, Sort.by(dir, sortProperties));
        query.with(pageable);

        return mapper.toEntityList(mongoTemplate.find(query, SizeDocument.class));
    }
}
