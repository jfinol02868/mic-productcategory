package com.tecomerce.appproductcategory.infrastructure.bd.repository.impl;

import com.tecomerce.appproductcategory.domain.entity.Size;
import com.tecomerce.appproductcategory.domain.exception.EntityNotFoundException;
import com.tecomerce.appproductcategory.domain.repository.SizeRepository;
import com.tecomerce.appproductcategory.infrastructure.bd.document.ColorDocument;
import com.tecomerce.appproductcategory.infrastructure.bd.document.SizeDocument;
import com.tecomerce.appproductcategory.infrastructure.bd.mapper.SizeMapper;
import com.tecomerce.appproductcategory.infrastructure.bd.repository.SizeRepositoryAdapter;
import com.tecomerce.appproductcategory.infrastructure.util.IdGenerator;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@AllArgsConstructor
public class SizeRepositoryImpl implements SizeRepository {

    private final SizeMapper mapper;
    private final IdGenerator idGenerator;
    private final MongoTemplate mongoTemplate;
    private final SizeRepositoryAdapter sRepository;

    @Override
    public Size create(Size entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(SizeDocument.class));
        return mapper.toEntity(sRepository.save(mapper.toDocument(entity)));
    }

    @Override
    public List<Size> createAll(List<Size> entities) {
        entities = entities.stream().peek(entity -> {
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(SizeDocument.class));
        }).collect(Collectors.toList());
        return mapper.toEntityList(sRepository.saveAll(mapper.toDocumentList(entities)));
    }

    @Override
    public Size update(Size entity, String id) {
//        ColorDocument color = sRepository.findById(id).orElseThrow(EntityNotFoundException::new);
//        entity.setId(id);
//        BeanUtils.copyProperties(entity, color);
//        return mapper.toEntity(sRepository.save(color));
        return null;
    }

    @Override
    public List<Size> updateAll(List<Size> entities) {
//        return entities.stream()
//                .flatMap(entity -> sRepository.findById(entity.getId())
//                        .map(existingEntity -> {
//                            BeanUtils.copyProperties(entity, existingEntity);
//                            return Stream.of(mapper.toEntity(cRepository.save(existingEntity)));
//                        })
//                        .orElseGet(() -> {
//                            log.info("Entity not found with ID: " + entity.getId());
//                            return Stream.empty();
//                        })
//                )
//                .collect(Collectors.toList());
        return null;
    }

    @Override
    public Size findById(String s) {
        return SizeRepository.super.findById(s);
    }

    @Override
    public List<Size> findByIds(List<String> id) {
        return SizeRepository.super.findByIds(id);
    }

    @Override
    public void delete(String id) {
        SizeRepository.super.delete(id);
    }

    @Override
    public List<Size> deleteAll(List<String> strings) {
        return SizeRepository.super.deleteAll(strings);
    }

    @Override
    public List<Size> findAllPaginated(int page, int size, String sort, String direction) {
        return SizeRepository.super.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public List<Size> filterColors(String id, String name, String code, String hex, String rgb, int page, int size, String direction, String... properties) {
        return SizeRepository.super.filterColors(id, name, code, hex, rgb, page, size, direction, properties);
    }
}
