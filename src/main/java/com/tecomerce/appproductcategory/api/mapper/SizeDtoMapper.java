package com.tecomerce.appproductcategory.api.mapper;

import com.tecomerce.appproductcategory.api.service.dto.SizeDTO;
import com.tecomerce.appproductcategory.domain.entity.Size;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SizeDtoMapper {

    public Size toEntity(SizeDTO sizeDTO);

    public SizeDTO toDto(Size size);

    public List<Size> toEntityList(List<SizeDTO> sizeDTOS);

    public List<SizeDTO> toDtoList(List<Size> sizes);
}
