package com.tecomerce.appproductcategory.api.service;

import com.tecomerce.appproductcategory.api.service.dto.CategoryDTO;
import com.tecomerce.appproductcategory.api.service.dto.ColorDTO;
import com.tecomerce.appproductcategory.api.service.dto.MessageResponseDTO;
import com.tecomerce.appproductcategory.api.service.dto.enums.SortEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ColorApi {

    static final String MEDIA_TYPE = "application/json";

    @PostMapping
    @Operation( operationId = "creation-color", description = "Creation of color.")
    @ApiResponse(responseCode = "201", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = ColorDTO.class)))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<ColorDTO> create(@Valid @RequestBody ColorDTO entity) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping("/create-all")
    @Operation( operationId = "create-all-color", description = "Create all colors.")
    @ApiResponse(responseCode = "201", content = @Content(mediaType = MEDIA_TYPE,  array = @ArraySchema(schema = @Schema(implementation = ColorDTO.class))))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default  ResponseEntity<List<ColorDTO>> createAll(@Valid @RequestBody List<ColorDTO> entities) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/{id}")
    @Operation( operationId = "update-color", description = "Update color.")
    @ApiResponse(responseCode = "201", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = ColorDTO.class)))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<ColorDTO> update(@Valid @RequestBody ColorDTO entity, @PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/update-all")
    @Operation( operationId = "update-all-colors", description = "Update all colors.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE,  array = @ArraySchema(schema = @Schema(implementation = ColorDTO.class))))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<List<ColorDTO>> updateAll(@Valid @RequestBody List<ColorDTO> entities){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/{id}")
    @Operation( operationId = "get-color-by-id", description = "Get color by id.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = ColorDTO.class)))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<ColorDTO> findById(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/get")
    @Operation( operationId = "get-colors-by-ids", description = "Get colors by ids.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE,  array = @ArraySchema(schema = @Schema(implementation = ColorDTO.class))))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<List<ColorDTO>> findByIds(@RequestParam List<String> id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/{id}")
    @Operation( operationId = "delete-color", description = "Delete color by id.")
    @ApiResponse(responseCode = "204", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = Void.class)))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<Void> delete(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/delete")
    @Operation( operationId = "delete-all-colors", description = "Delete colors by ids.")
    @ApiResponse(responseCode = "204", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = Void.class)))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<Void> deleteAll(@RequestParam List<String> ids) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/paginated")
    @Operation( operationId = "get-colors-paginated", description = "Get colors paginated.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE,  array = @ArraySchema(schema = @Schema(implementation = ColorDTO.class))))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<List<ColorDTO>> findAllPaginated(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, String sort, SortEnum direction) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @GetMapping("/category-filter")
    @Operation( operationId = "get-categories-filter", description = "Get categories filter.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE,  array = @ArraySchema(schema = @Schema(implementation = CategoryDTO.class))))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<List<ColorDTO>> filters(
            @RequestParam(required = false, defaultValue = "{\"name\":\"Negro\", \"code\":\"000001\", \"hex\":\"#000000\"}") String filterProperties,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false) SortEnum direction,
            @RequestParam(required = false, defaultValue = "createAt") String... sortProperties) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


}
