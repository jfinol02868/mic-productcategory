package com.tecomerce.appproductcategory.api.mapper;

import com.tecomerce.appproductcategory.domain.entity.Location;
import com.tecomerce.appproductcategory.domain.util.mapper.BaseMapper;
import com.tecomerce.appproductcategory.infrastructure.bd.document.LocationDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper extends BaseMapper<Location, LocationDocument>{
}
