package com.tecomerce.appproductcategory.api.mapper;

import com.tecomerce.appproductcategory.api.service.dto.ColorDTO;
import com.tecomerce.appproductcategory.domain.entity.Color;
import com.tecomerce.appproductcategory.domain.util.mapper.BaseDtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ColorMapper extends BaseDtoMapper<Color, ColorDTO> {
}
