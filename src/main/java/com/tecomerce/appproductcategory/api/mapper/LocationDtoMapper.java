package com.tecomerce.appproductcategory.api.mapper;

import com.tecomerce.appproductcategory.api.service.dto.LocationDTO;
import com.tecomerce.appproductcategory.domain.entity.Location;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationDtoMapper {

    public Location toEntity(LocationDTO locationDTO);

    public LocationDTO toDto(Location location);

    public List<Location> toEntityList(List<LocationDTO> locationDTOS);

    public List<LocationDTO> toDtoList(List<Location> locations);
}
