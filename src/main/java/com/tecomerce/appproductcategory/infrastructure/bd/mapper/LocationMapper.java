package com.tecomerce.appproductcategory.infrastructure.bd.mapper;

import com.tecomerce.appproductcategory.domain.entity.Location;
import com.tecomerce.appproductcategory.infrastructure.bd.document.LocationDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    public Location toEntity(LocationDocument locationDocument);

    public LocationDocument toDocument(Location location);

    public List<Location> toEntityList(List<LocationDocument> locationDocuments);

    public List<LocationDocument> toDocumentList(List<Location> locations);
}
