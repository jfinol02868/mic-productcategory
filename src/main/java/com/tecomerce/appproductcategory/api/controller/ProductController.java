package com.tecomerce.appproductcategory.api.controller;

import com.tecomerce.appproductcategory.api.service.ProductApi;
import com.tecomerce.appproductcategory.api.service.dto.ProductDTO;
import com.tecomerce.appproductcategory.api.service.dto.enums.SortEnumDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/products")
@Tags(value = {@Tag(name = "Product", description = "Product API")})
public class ProductController implements ProductApi {

    @Override
    public ResponseEntity<ProductDTO> create(ProductDTO entity) {
        return ProductApi.super.create(entity);
    }

    @Override
    public ResponseEntity<List<ProductDTO>> createAll(List<ProductDTO> entities) {
        return ProductApi.super.createAll(entities);
    }

    @Override
    public ResponseEntity<ProductDTO> update(ProductDTO entity, String id) {
        return ProductApi.super.update(entity, id);
    }

    @Override
    public ResponseEntity<List<ProductDTO>> updateAll(List<ProductDTO> entities) {
        return ProductApi.super.updateAll(entities);
    }

    @Override
    public ResponseEntity<ProductDTO> findById(String id) {
        return ProductApi.super.findById(id);
    }

    @Override
    public ResponseEntity<List<ProductDTO>> findByIds(List<String> id) {
        return ProductApi.super.findByIds(id);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        return ProductApi.super.delete(id);
    }

    @Override
    public ResponseEntity<Void> deleteAll(List<String> ids) {
        return ProductApi.super.deleteAll(ids);
    }

    @Override
    public ResponseEntity<List<ProductDTO>> findAllPaginated(int page, int size, String sort, SortEnumDTO direction) {
        return ProductApi.super.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public ResponseEntity<List<ProductDTO>> filters(String filterProperties, int page, int size, SortEnumDTO direction, String... sortProperties) {
        return ProductApi.super.filters(filterProperties, page, size, direction, sortProperties);
    }
}
