package com.tecomerce.appproductcategory.api.controller;

import com.tecomerce.appproductcategory.api.mapper.ColorMapper;
import com.tecomerce.appproductcategory.api.service.ColorApi;
import com.tecomerce.appproductcategory.api.service.dto.ColorDTO;
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

    private final ColorMapper mapper;
    private final ColorUseCase colorUserCase;

    @Override
    public ResponseEntity<ColorDTO> create(ColorDTO entity) {
        return new ResponseEntity<>(mapper.toDot(colorUserCase.create(
                mapper.toEntity(entity))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ColorDTO> update(ColorDTO entity, String id) {
        return new ResponseEntity<>(mapper.toDot(colorUserCase.update(
                mapper.toEntity(entity), id)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ColorDTO> findById(String id) {
        return new ResponseEntity<>(mapper.toDot(colorUserCase.findById(id)),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        colorUserCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<ColorDTO>> findAll(int page, int size, String sort, String direction, String search, String filter) {
        return new ResponseEntity<>(mapper.toDtoList(colorUserCase
                .findAll(page, size, sort, direction, search, filter)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ColorDTO>> updateAll(List<ColorDTO> entities) {
        return new ResponseEntity<>(mapper.toDtoList(colorUserCase
                .updateAll(mapper.toEntityList(entities))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ColorDTO>> findByIds(List<String> ids) {
        return new ResponseEntity<>(mapper.toDtoList(colorUserCase.findByIds(ids)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ColorDTO>> createAll(List<ColorDTO> entities) {
        return new ResponseEntity<>(mapper.toDtoList(colorUserCase
                .createAll(mapper.toEntityList(entities))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteAll(List<String> ids) {
        colorUserCase.deleteAll(ids);
        return ResponseEntity.noContent().build();
    }
}
