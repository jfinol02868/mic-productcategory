package com.tecomerce.appproductcategory.api.controller;

import com.tecomerce.appproductcategory.api.mapper.CategoryDetailDtoMapper;
import com.tecomerce.appproductcategory.api.mapper.CategoryDtoMapper;
import com.tecomerce.appproductcategory.api.service.CategoryApi;
import com.tecomerce.appproductcategory.api.service.CategoryDetailApi;
import com.tecomerce.appproductcategory.api.service.dto.CategoryDTO;
import com.tecomerce.appproductcategory.api.service.dto.CategoryDetailDTO;
import com.tecomerce.appproductcategory.api.service.dto.enums.SortEnumDTO;
import com.tecomerce.appproductcategory.application.usecase.CategoryDetailUseCase;
import com.tecomerce.appproductcategory.application.usecase.CategoryUseCase;
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
@RequestMapping("/v1/categories")
@Tags(value = {@Tag(name = "Category", description = "Category API")})
public class CategoryController implements CategoryApi, CategoryDetailApi {

    private final CategoryUseCase useCase;
    private final CategoryDtoMapper mapper;
    private final CategoryDetailUseCase cDUseCase;
    private final CategoryDetailDtoMapper cDMapper;

    @Override
    public ResponseEntity<CategoryDTO> create(CategoryDTO entity) {
        return new ResponseEntity<>(mapper.toDto(useCase.create(
                mapper.toEntity(entity))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CategoryDTO>> createAll(List<CategoryDTO> entities) {
        return new ResponseEntity<>(mapper.toDtoList((useCase.createAll(
                mapper.toEntityList(entities)))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CategoryDTO> update(CategoryDTO entity, String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.update(
                mapper.toEntity(entity), id)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CategoryDTO>> updateAll(List<CategoryDTO> entities) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.createAll(
                mapper.toEntityList(entities))) , HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CategoryDTO> findById(String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.findById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CategoryDTO>> findByIds(List<String> id) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.findByIds(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> delete(String id, boolean deleteChildren) {
        useCase.delete(id, deleteChildren);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteAll(List<String> ids) {
        useCase.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<CategoryDTO>> findAllPaginated(int page, int size, String sort, SortEnumDTO direction) {
        return new ResponseEntity<>(mapper.toDtoList(
                useCase.findAllPaginated(page, size, sort, direction.getValue())), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CategoryDTO>> filters(String filterProperties, int page, int size,
                                                     SortEnumDTO direction, String... sortProperties) {
        return new ResponseEntity<>(mapper.toDtoList(
                useCase.filters(filterProperties, page, size, direction.getValue(), sortProperties)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryDetailDTO> findDetailById(String id) {
        return new ResponseEntity<>(cDMapper.toDto(cDUseCase.findCategoryDetailByCategoryId(id)), HttpStatus.OK);
    }
}
