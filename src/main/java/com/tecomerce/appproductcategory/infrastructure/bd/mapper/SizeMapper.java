package com.tecomerce.appproductcategory.infrastructure.bd.mapper;

import com.tecomerce.appproductcategory.domain.entity.Size;
import com.tecomerce.appproductcategory.infrastructure.bd.document.SizeDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SizeMapper extends BaseMapper<Size, SizeDocument>{
}
