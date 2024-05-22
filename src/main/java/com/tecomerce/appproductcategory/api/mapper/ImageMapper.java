package com.tecomerce.appproductcategory.api.mapper;

import com.tecomerce.appproductcategory.api.service.dto.ImageDTO;
import com.tecomerce.appproductcategory.domain.entity.Image;
import com.tecomerce.appproductcategory.domain.util.mapper.BaseDtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper extends BaseDtoMapper<Image, ImageDTO> {
}
