package com.tecomerce.appproductcategory.api.controller;

import com.tecomerce.appproductcategory.api.mapper.CategoryGroupDtoMapper;
import com.tecomerce.appproductcategory.api.service.CategoryGroupApi;
import com.tecomerce.appproductcategory.api.service.dto.CategoryGroupDTO;
import com.tecomerce.appproductcategory.api.service.dto.enums.SortEnumDTO;
import com.tecomerce.appproductcategory.application.usecase.CategoryGroupUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/categoryGroups")
@Tags(value = {@Tag(name = "Category Groups", description = "Category Groups API")})
public class CategoryGroupController implements CategoryGroupApi {

    private final CategoryGroupUseCase useCase;
    private final CategoryGroupDtoMapper mapper;

    @Override
    public ResponseEntity<CategoryGroupDTO> create(CategoryGroupDTO entity) {
        return new ResponseEntity<>(mapper.toDto(useCase.create(
                mapper.toEntity(entity))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CategoryGroupDTO>> createAll(List<CategoryGroupDTO> entities) {
        return new ResponseEntity<>(mapper.toDtoList((useCase.createAll(
                mapper.toEntityList(entities)))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CategoryGroupDTO> update(CategoryGroupDTO entity, String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.update(
                mapper.toEntity(entity), id)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CategoryGroupDTO>> updateAll(List<CategoryGroupDTO> entities) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.createAll(
                mapper.toEntityList(entities))) , HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CategoryGroupDTO> findById(String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.findById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CategoryGroupDTO>> findByIds(List<String> id) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.findByIds(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        useCase.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteAll(List<String> ids) {
        useCase.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<CategoryGroupDTO>> findAllPaginated(int page, int size, String sort, SortEnumDTO direction) {
        return new ResponseEntity<>(mapper.toDtoList(
                useCase.findAllPaginated(page, size, sort, direction.getValue())), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CategoryGroupDTO>> filters(String filterProperties, int page, int size,
                                                     SortEnumDTO direction, String... sortProperties) {
        return new ResponseEntity<>(mapper.toDtoList(
                useCase.filters(filterProperties, page, size, direction.getValue(), sortProperties)), HttpStatus.OK);
    }

}
