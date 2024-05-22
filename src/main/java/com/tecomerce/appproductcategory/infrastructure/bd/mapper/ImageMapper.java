package com.tecomerce.appproductcategory.infrastructure.bd.mapper;

import com.tecomerce.appproductcategory.domain.entity.Image;
import com.tecomerce.appproductcategory.domain.util.mapper.BaseMapper;
import com.tecomerce.appproductcategory.infrastructure.bd.document.ImageDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper extends BaseMapper<Image, ImageDocument> {
}
