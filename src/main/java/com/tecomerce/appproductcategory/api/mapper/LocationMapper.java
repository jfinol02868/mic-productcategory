package com.tecomerce.appproductcategory.api.mapper;

import com.tecomerce.appproductcategory.api.service.dto.LocationDTO;
import com.tecomerce.appproductcategory.domain.entity.Location;
import com.tecomerce.appproductcategory.domain.util.mapper.BaseDtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper extends BaseDtoMapper<Location, LocationDTO> {
}
