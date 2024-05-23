package com.tecomerce.appproductcategory.api.controller;

import com.tecomerce.appproductcategory.api.mapper.ColorDtoMapper;
import com.tecomerce.appproductcategory.api.service.ColorApi;
import com.tecomerce.appproductcategory.api.service.dto.ColorDTO;
import com.tecomerce.appproductcategory.api.service.dto.SortEnum;
import com.tecomerce.appproductcategory.application.usecase.ColorUseCase;
import com.tecomerce.appproductcategory.domain.entity.Color;
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
    private final ColorUseCase colorUserCase;

    @Override
    public ResponseEntity<ColorDTO> create(ColorDTO entity) {
        return new ResponseEntity<>(mapper.toDto(colorUserCase.create(
                mapper.toEntity(entity))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ColorDTO> update(ColorDTO entity, String id) {
        return new ResponseEntity<>(mapper.toDto(colorUserCase.update(
                mapper.toEntity(entity), id)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ColorDTO> findById(String id) {
        return new ResponseEntity<>(mapper.toDto(colorUserCase.findById(id)),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        colorUserCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<ColorDTO>> findAll(int page, int size, String sort, SortEnum direction) {
        return new ResponseEntity<>(mapper.toDtoList(colorUserCase
                .findAll(page, size, sort, direction.getValue())), HttpStatus.OK);
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
    public ResponseEntity<List<ColorDTO>> deleteAll(List<String> ids) {
        return new ResponseEntity<>(mapper.toDtoList(colorUserCase.deleteAll(ids)),HttpStatus.OK);
    }
}
