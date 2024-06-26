package com.tecomerce.appproductcategory.infrastructure.bd.repository.impl;

import com.tecomerce.appproductcategory.domain.entity.Product;
import com.tecomerce.appproductcategory.domain.exception.EntityNotFoundException;
import com.tecomerce.appproductcategory.domain.repository.ProductRepository;
import com.tecomerce.appproductcategory.infrastructure.bd.document.ProductDocument;
import com.tecomerce.appproductcategory.infrastructure.bd.mapper.ProductMapper;
import com.tecomerce.appproductcategory.infrastructure.bd.repository.ProductRepositoryAdapter;
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
public class ProductRepositoryImpl implements ProductRepository {


    private final ProductMapper mapper;
    private final IdGenerator idGenerator;
    private final MongoTemplate mongoTemplate;
    private final DynamicFilterMap dynamicFilterMap;
    private final ProductRepositoryAdapter repository;

    @Override
    public Product create(Product entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(ProductDocument.class));
        entity.dateOfCreation();
        return mapper.toEntity(repository.save(mapper.toDocument(entity)));
    }

    @Override
    public List<Product> createAll(List<Product> entities) {
        entities = entities.stream().peek(entity -> {
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(ProductDocument.class));
        }).collect(Collectors.toList());
        return mapper.toEntityList(repository.saveAll(mapper.toDocumentList(entities)));
    }

    @Override
    public Product update(Product entity, String id) {
        ProductDocument product = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        entity.setId(id);
        entity.setCreateAt(product.getCreateAt());
        BeanUtils.copyProperties(entity, product);
        return mapper.toEntity(repository.save(product));
    }

    @Override
    public List<Product> updateAll(List<Product> entities) {
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
    public Product findById(String s) {
        return mapper.toEntity(repository.findById(s).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<Product> findByIds(List<String> ids) {
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
    public List<Product> findAllPaginated(int page, int size, String sort, String direction) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(dir, sort));
        Page<ProductDocument> product = repository.findAll(pageRequest);
        return mapper.toEntityList(product.getContent());
    }

    @Override
    public List<Product> filters(Product product, int page, int size, String direction, String... sortProperties) {
        Field[] fields = Product.class.getDeclaredFields();
        Query query = dynamicFilterMap.queryFilter(fields, product, page, size, direction, sortProperties);
        return mapper.toEntityList(mongoTemplate.find(query, ProductDocument.class));
    }
}
