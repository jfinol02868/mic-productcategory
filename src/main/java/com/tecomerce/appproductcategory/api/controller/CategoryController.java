package com.tecomerce.appproductcategory.api.controller;

import com.tecomerce.appproductcategory.api.service.CategoryApi;
import com.tecomerce.appproductcategory.api.service.dto.CategoryDTO;
import com.tecomerce.appproductcategory.api.service.dto.enums.SortEnum;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/category")
@Tags(value = {@Tag(name = "Category", description = "Category API")})
public class CategoryController implements CategoryApi {

    @Override
    public ResponseEntity<CategoryDTO> create(CategoryDTO entity) {
        return CategoryApi.super.create(entity);
    }

    @Override
    public ResponseEntity<List<CategoryDTO>> createAll(List<CategoryDTO> entities) {
        return CategoryApi.super.createAll(entities);
    }

    @Override
    public ResponseEntity<CategoryDTO> update(CategoryDTO entity, String id) {
        return CategoryApi.super.update(entity, id);
    }

    @Override
    public ResponseEntity<List<CategoryDTO>> updateAll(List<CategoryDTO> entities) {
        return CategoryApi.super.updateAll(entities);
    }

    @Override
    public ResponseEntity<CategoryDTO> findById(String id) {
        return CategoryApi.super.findById(id);
    }

    @Override
    public ResponseEntity<List<CategoryDTO>> findByIds(List<String> id) {
        return CategoryApi.super.findByIds(id);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        return CategoryApi.super.delete(id);
    }

    @Override
    public ResponseEntity<Void> deleteAll(List<String> ids) {
        return CategoryApi.super.deleteAll(ids);
    }

    @Override
    public ResponseEntity<List<CategoryDTO>> findAllPaginated(int page, int size, String sort, SortEnum direction) {
        return CategoryApi.super.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public ResponseEntity<List<CategoryDTO>> filterColors(String params, int page, int size, SortEnum direction, String... properties) {
        return CategoryApi.super.filterColors(params, page, size, direction, properties);
    }
}
