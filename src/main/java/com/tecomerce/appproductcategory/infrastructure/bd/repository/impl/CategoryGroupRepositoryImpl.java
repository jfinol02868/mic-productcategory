package com.tecomerce.appproductcategory.infrastructure.bd.repository.impl;

import com.tecomerce.appproductcategory.domain.entity.CategoryGroup;
import com.tecomerce.appproductcategory.domain.entity.CategoryGroupDetail;
import com.tecomerce.appproductcategory.domain.entity.Color;
import com.tecomerce.appproductcategory.domain.exception.EntityNotFoundException;
import com.tecomerce.appproductcategory.domain.repository.CategoryGroupDetailRepository;
import com.tecomerce.appproductcategory.domain.repository.CategoryGroupRepository;
import com.tecomerce.appproductcategory.infrastructure.bd.document.CategoryGroupDetailDocument;
import com.tecomerce.appproductcategory.infrastructure.bd.document.CategoryGroupDocument;
import com.tecomerce.appproductcategory.infrastructure.bd.document.ColorDocument;
import com.tecomerce.appproductcategory.infrastructure.bd.mapper.CategoryGroupDetailMapper;
import com.tecomerce.appproductcategory.infrastructure.bd.mapper.CategoryGroupMapper;
import com.tecomerce.appproductcategory.infrastructure.bd.repository.CategoryGroupDetailRepositoryAdapter;
import com.tecomerce.appproductcategory.infrastructure.bd.repository.CategoryGroupRepositoryAdapter;
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
public class CategoryGroupRepositoryImpl implements CategoryGroupRepository, CategoryGroupDetailRepository {

    private final CategoryGroupMapper mapper;
    private final IdGenerator idGenerator;
    private final MongoTemplate mongoTemplate;
    private final DynamicFilterMap dynamicFilterMap;
    private final CategoryGroupRepositoryAdapter repository;
    private final CategoryGroupDetailMapper cGDMapper;
    private final CategoryGroupDetailRepositoryAdapter cGDRepository;

    @Override
    public CategoryGroup create(CategoryGroup entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(ColorDocument.class));
        return mapper.toEntity(repository.save(mapper.toDocument(entity)));
    }

    @Override
    public List<CategoryGroup> createAll(List<CategoryGroup> entities) {
        entities = entities.stream().peek(entity -> {
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(CategoryGroupDocument.class));
        }).collect(Collectors.toList());
        return mapper.toEntityList(repository.saveAll(mapper.toDocumentList(entities)));
    }

    @Override
    public CategoryGroup update(CategoryGroup entity, String id) {
        CategoryGroupDocument document = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        entity.setId(id);
        entity.setCreateAt(document.getCreateAt());
        BeanUtils.copyProperties(entity, document);
        return mapper.toEntity(repository.save(document));
    }

    @Override
    public List<CategoryGroup> updateAll(List<CategoryGroup> entities) {
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
    public CategoryGroup findById(String id) {
        return mapper.toEntity(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<CategoryGroup> findByIds(List<String> ids) {
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
    public List<CategoryGroup> findAllPaginated(int page, int CategoryGroup, String sort, String direction) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageRequest = PageRequest.of(page, CategoryGroup, Sort.by(dir, sort));
        Page<CategoryGroupDocument> colorPage = repository.findAll(pageRequest);
        return mapper.toEntityList(colorPage.getContent());
    }

    @Override
    public List<CategoryGroup> filters(CategoryGroup categoryGroup, int page, int size, String direction, String... sortProperties) {
        Field[] fields = Color.class.getDeclaredFields();
        Query query = dynamicFilterMap.queryFilter(fields, categoryGroup, page, size, direction, sortProperties);
        return mapper.toEntityList(mongoTemplate.find(query, CategoryGroupDocument.class));
    }

    @Override
    public CategoryGroupDetail findCategoryGroupDetailById(String categoryId) {
        return cGDMapper.toEntity(cGDRepository.findById(categoryId).orElseThrow(() -> new EntityNotFoundException(categoryId)));
    }
}
