package com.tecomerce.appproductcategory.api.controller;

import com.tecomerce.appproductcategory.api.mapper.ImageDtoMapper;
import com.tecomerce.appproductcategory.api.service.ImageApi;
import com.tecomerce.appproductcategory.api.service.dto.ImageDTO;
import com.tecomerce.appproductcategory.api.service.dto.enums.SortEnumDTO;
import com.tecomerce.appproductcategory.application.usecase.ImageUseCase;
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
@RequestMapping("/v1/images")
@Tags(value = {@Tag(name = "Image", description = "Image API")})
public class ImageController implements ImageApi {

    private ImageDtoMapper mapper;
    private final ImageUseCase useCase;

    @Override
    public ResponseEntity<ImageDTO> create(ImageDTO entity) {
        return new ResponseEntity<>(mapper.toDto(useCase.create(
                mapper.toEntity(entity))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ImageDTO>> createAll(List<ImageDTO> entities) {
        return new ResponseEntity<>(mapper.toDtoList(useCase
                .createAll(mapper.toEntityList(entities))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ImageDTO> update(ImageDTO entity, String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.update(
                mapper.toEntity(entity), id)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ImageDTO>> updateAll(List<ImageDTO> entities) {
        return new ResponseEntity<>(mapper.toDtoList(useCase
                .updateAll(mapper.toEntityList(entities))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ImageDTO> findById(String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.findById(id)),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ImageDTO>> findByIds(List<String> ids) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.findByIds(ids)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        useCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteAll(List<String> ids) {
        useCase.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<ImageDTO>> findAllPaginated(int page, int size, String sort, SortEnumDTO direction) {
        return new ResponseEntity<>(mapper.toDtoList(useCase
                .findAllPaginated(page, size, sort, direction.getValue())), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ImageDTO>> filters(String filterProperties, int page, int size, SortEnumDTO direction,
                                                  String... sortProperties) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.filters(filterProperties, page, size, direction.getValue(),
                sortProperties)), HttpStatus.OK);
    }
}
