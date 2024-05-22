package com.tecomerce.appproductcategory.api.service;

import com.tecomerce.appproductcategory.api.service.dto.MessageResponseDTO;
import com.tecomerce.appproductcategory.api.service.dto.ProductDTO;
import com.tecomerce.appproductcategory.domain.entity.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface ProductApi {

    static final String MEDIA_TYPE = "application/json";

    @PostMapping
    @Operation( operationId = "creation-product", description = "Creation of products.")
    @ApiResponse(responseCode = "201", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = ProductDTO.class)))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default Product create(Product entity) {
        return null;
    }

    default Product update(Product entity, Long id) {
        return null;
    }

    default Product findById(String id) {
        return null;
    }

    default void delete(String id) {

    }

    default List<Product> findAll(int page, int size, String sort, String direction, String search, String filter) {
        return null;
    }

    default Product updateAll(List<Product> entities){
        return null;
    }

    default List<Product> findByIds(List<String> id) {
        return null;
    }

    default Product createAll(List<Product> entities) {
        return null;
    }

    default Void deleteAll(List<String> ids) {
        return null;
    }
}
