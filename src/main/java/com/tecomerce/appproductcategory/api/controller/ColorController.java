package com.tecomerce.appproductcategory.api.controller;

import com.tecomerce.appproductcategory.api.mapper.ColorDtoMapper;
import com.tecomerce.appproductcategory.api.service.ColorApi;
import com.tecomerce.appproductcategory.api.service.dto.ColorDTO;
import com.tecomerce.appproductcategory.api.service.dto.enums.SortEnum;
import com.tecomerce.appproductcategory.application.usecase.ColorUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/colors")
public class ColorController implements ColorApi {

    private final ColorDtoMapper mapper;
    private final ColorUseCase userCase;

    @Override
    public ResponseEntity<ColorDTO> create(ColorDTO entity) {
        return new ResponseEntity<>(mapper.toDto(userCase.create(
                mapper.toEntity(entity))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ColorDTO> update(ColorDTO entity, String id) {
        return new ResponseEntity<>(mapper.toDto(userCase.update(
                mapper.toEntity(entity), id)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ColorDTO> findById(String id) {
        return new ResponseEntity<>(mapper.toDto(userCase.findById(id)),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        userCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<ColorDTO>> findAllPaginated(int page, int size, String sort, SortEnum direction) {
        return new ResponseEntity<>(mapper.toDtoList(userCase
                .findAllPaginated(page, size, sort, direction.getValue())), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ColorDTO>> updateAll(List<ColorDTO> entities) {
        return new ResponseEntity<>(mapper.toDtoList(userCase
                .updateAll(mapper.toEntityList(entities))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ColorDTO>> findByIds(List<String> ids) {
        return new ResponseEntity<>(mapper.toDtoList(userCase.findByIds(ids)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ColorDTO>> createAll(List<ColorDTO> entities) {
        return new ResponseEntity<>(mapper.toDtoList(userCase
                .createAll(mapper.toEntityList(entities))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteAll(List<String> ids) {
        userCase.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<ColorDTO>> filterColors(String id, String name, String code, String hex, String rgb,
                                                       int page, int size, SortEnum direction, String... properties) {
        return new ResponseEntity<>(mapper.toDtoList(userCase
                .filterColors(id, name, code, hex, rgb, page, size, direction.getValue(), properties)),HttpStatus.OK);
    }
}
