package com.tecomerce.appproductcategory.api.service;

import com.tecomerce.appproductcategory.api.service.dto.SizeDTO;
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

public interface SizeApi {

    static final String MEDIA_TYPE = "application/json";

    @PostMapping
    @Operation( operationId = "creation-size", description = "Creation of size.")
    @ApiResponse(responseCode = "201", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = SizeDTO.class)))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<SizeDTO> create(@Valid @RequestBody SizeDTO entity) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping("/create-all")
    @Operation( operationId = "create-all-size", description = "Create all size.")
    @ApiResponse(responseCode = "201", content = @Content(mediaType = MEDIA_TYPE,  array = @ArraySchema(schema = @Schema(implementation = SizeDTO.class))))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default  ResponseEntity<List<SizeDTO>> createAll(@Valid @RequestBody List<SizeDTO> entities) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/{id}")
    @Operation( operationId = "update-size", description = "Update size.")
    @ApiResponse(responseCode = "201", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = SizeDTO.class)))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<SizeDTO> update(@Valid @RequestBody SizeDTO entity, @PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/update-all")
    @Operation( operationId = "update-all-sizes", description = "Update all sizes.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE,  array = @ArraySchema(schema = @Schema(implementation = SizeDTO.class))))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<List<SizeDTO>> updateAll(@Valid @RequestBody List<SizeDTO> entities){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/{id}")
    @Operation( operationId = "get-size-by-id", description = "Get size by id.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = SizeDTO.class)))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<SizeDTO> findById(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/get")
    @Operation( operationId = "get-sizes-by-ids", description = "Get sizes by ids.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE,  array = @ArraySchema(schema = @Schema(implementation = SizeDTO.class))))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<List<SizeDTO>> findByIds(@RequestParam List<String> id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/{id}")
    @Operation( operationId = "delete-size", description = "Delete size by id.")
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
    @Operation( operationId = "delete-all-sizes", description = "Delete sizes by ids.")
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
    @Operation( operationId = "get-sizes-paginated", description = "Get sizes paginated.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE,  array = @ArraySchema(schema = @Schema(implementation = SizeDTO.class))))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<List<SizeDTO>> findAllPaginated(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, String sort, SortEnum direction) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/size-filter")
    @Operation( operationId = "get-sizes-filter", description = "Get sizes filter.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE,  array = @ArraySchema(schema = @Schema(implementation = SizeDTO.class))))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<List<SizeDTO>> filterColors(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String size,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int records,
            @RequestParam(required = false) SortEnum direction,
            @RequestParam(required = false) String... properties) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


}
