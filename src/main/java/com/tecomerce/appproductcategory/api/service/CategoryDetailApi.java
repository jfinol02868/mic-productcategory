package com.tecomerce.appproductcategory.api.service;

import com.tecomerce.appproductcategory.api.service.dto.CategoryDetailDTO;
import com.tecomerce.appproductcategory.api.service.dto.MessageResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CategoryDetailApi {

    static final String MEDIA_TYPE = "application/json";

    @GetMapping("/{id}/getDetails")
    @Operation( operationId = "get-detail-category-by-id", description = "Get detail category by id.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = CategoryDetailDTO.class)))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<CategoryDetailDTO> findDetailById(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
