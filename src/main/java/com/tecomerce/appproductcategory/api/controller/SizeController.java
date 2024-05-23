package com.tecomerce.appproductcategory.api.controller;

import com.tecomerce.appproductcategory.api.mapper.SizeDtoMapper;
import com.tecomerce.appproductcategory.api.service.SizeApi;
import com.tecomerce.appproductcategory.api.service.dto.SizeDTO;
import com.tecomerce.appproductcategory.api.service.dto.enums.SortEnum;
import com.tecomerce.appproductcategory.application.usecase.SizeUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sizes")
public class SizeController implements SizeApi {

    private final SizeDtoMapper mapper;
    private final SizeUseCase useCase;

    @Override
    public ResponseEntity<SizeDTO> create(SizeDTO entity) {
        return new ResponseEntity<>(mapper.toDto(useCase.create(
                mapper.toEntity(entity))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<SizeDTO> update(SizeDTO entity, String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.update(
                mapper.toEntity(entity), id)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<SizeDTO> findById(String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.findById(id)),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        useCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<SizeDTO>> findAllPaginated(int page, int size, String sort, SortEnum direction) {
        return new ResponseEntity<>(mapper.toDtoList(useCase
                .findAllPaginated(page, size, sort, direction.getValue())), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<SizeDTO>> updateAll(List<SizeDTO> entities) {
        return new ResponseEntity<>(mapper.toDtoList(useCase
                .updateAll(mapper.toEntityList(entities))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<SizeDTO>> findByIds(List<String> ids) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.findByIds(ids)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<SizeDTO>> createAll(List<SizeDTO> entities) {
        return new ResponseEntity<>(mapper.toDtoList(useCase
                .createAll(mapper.toEntityList(entities))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<SizeDTO>> deleteAll(List<String> ids) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.deleteAll(ids)),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<SizeDTO>> filterColors(String id, String name, String code, String hex, String rgb,
                                                       int page, int size, SortEnum direction, String... properties) {
        return new ResponseEntity<>(mapper.toDtoList(useCase
                .filterColors(id, name, code, hex, rgb, page, size, direction.getValue(), properties)),HttpStatus.OK);
    }

}
