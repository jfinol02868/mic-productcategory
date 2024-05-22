package com.tecomerce.appproductcategory.api.mapper;

import com.tecomerce.appproductcategory.domain.entity.Size;
import com.tecomerce.appproductcategory.domain.util.mapper.BaseMapper;
import com.tecomerce.appproductcategory.infrastructure.bd.document.SizeDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SizeMapper extends BaseMapper<Size, SizeDocument>{
}
