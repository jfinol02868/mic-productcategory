package com.tecomerce.appproductcategory.infrastructure.bd.mapper;

import com.tecomerce.appproductcategory.domain.entity.Color;
import com.tecomerce.appproductcategory.domain.util.mapper.BaseMapper;
import com.tecomerce.appproductcategory.infrastructure.bd.document.ColorDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ColorMapper extends BaseMapper<Color, ColorDocument> {
}
