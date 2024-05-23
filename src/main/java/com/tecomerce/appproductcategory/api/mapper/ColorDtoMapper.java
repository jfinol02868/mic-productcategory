package com.tecomerce.appproductcategory.api.mapper;

import com.tecomerce.appproductcategory.api.service.dto.ColorDTO;
import com.tecomerce.appproductcategory.domain.entity.Color;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColorDtoMapper {

    public Color toEntity(ColorDTO colorDTO);

    public ColorDTO toDto(Color color);

    public List<Color> toEntityList(List<ColorDTO> colorDTOS);

    public List<ColorDTO> toDtoList(List<Color> colors);
}
