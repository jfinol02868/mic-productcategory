package com.tecomerce.appproductcategory.infrastructure.bd.repository.impl;

import com.tecomerce.appproductcategory.domain.entity.Category;
import com.tecomerce.appproductcategory.domain.entity.CategoryDetail;
import com.tecomerce.appproductcategory.domain.exception.EntityNotFoundException;
import com.tecomerce.appproductcategory.domain.repository.CategoryDetailRepository;
import com.tecomerce.appproductcategory.domain.repository.CategoryRepository;
import com.tecomerce.appproductcategory.infrastructure.bd.document.CategoryDetailDocument;
import com.tecomerce.appproductcategory.infrastructure.bd.document.CategoryDocument;
import com.tecomerce.appproductcategory.infrastructure.bd.mapper.CategoryDetailMapper;
import com.tecomerce.appproductcategory.infrastructure.bd.mapper.CategoryMapper;
import com.tecomerce.appproductcategory.infrastructure.bd.repository.CategoryDetailRepositoryAdapter;
import com.tecomerce.appproductcategory.infrastructure.bd.repository.CategoryRepositoryAdapter;
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
public class CategoryRepositoryImpl implements CategoryRepository, CategoryDetailRepository {


    private final CategoryMapper mapper;
    private final IdGenerator idGenerator;
    private final MongoTemplate mongoTemplate;
    private final CategoryDetailMapper cDMapper;
    private final CategoryRepositoryAdapter repository;
    private final CategoryDetailRepositoryAdapter categoryDetailRepository;

    @Override
    public Category create(Category entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(CategoryDocument.class));
        entity.dateOfCreation();
        return mapper.toEntity(repository.save(mapper.toDocument(entity)));
    }

    @Override
    public List<Category> createAll(List<Category> entities) {
        entities = entities.stream().peek(entity -> {
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(CategoryDocument.class));
        }).collect(Collectors.toList());
        return mapper.toEntityList(repository.saveAll(mapper.toDocumentList(entities)));
    }

    @Override
    public Category update(Category entity, String id) {
        CategoryDocument category = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        entity.setId(id);
        BeanUtils.copyProperties(entity, category);
        return mapper.toEntity(repository.save(category));
    }

    @Override
    public List<Category> updateAll(List<Category> entities) {
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
    public Category findById(String id) {
        return mapper.toEntity(repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id)));
    }

    @Override
    public List<Category> findByIds(List<String> ids) {
        return mapper.toEntityList(repository.findAllById(ids));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll(List<String> ids) {
        repository.deleteAllById(ids);
    }

    @Override
    public List<Category> findAllPaginated(int page, int size, String sort, String direction) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(dir, sort));
        Page<CategoryDocument> category = repository.findAll(pageRequest);
        return mapper.toEntityList(category.getContent());
    }

    @Override
    public List<Category> filters(Category category, int page, int size, String direction, String... sortProperties) {

        Query query = new Query();
        Field[] fields = Category.class.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(category);
                if (Objects.nonNull(value)) query.addCriteria(Criteria.where(field.getName()).is(value));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageable = PageRequest.of(page, size, Sort.by(dir, sortProperties));
        query.with(pageable);

        return mapper.toEntityList(mongoTemplate.find(query, CategoryDocument.class));
    }

    @Override
    public CategoryDetail findCategoryDetailByCategoryId(String id) {
        return cDMapper.toEntity(categoryDetailRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id)));
    }
}
