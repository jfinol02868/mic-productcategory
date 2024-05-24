package com.tecomerce.appproductcategory.infrastructure.bd.mapper;

import com.tecomerce.appproductcategory.domain.entity.Color;
import com.tecomerce.appproductcategory.infrastructure.bd.document.ColorDocument;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColorMapper {

    public Color toEntity(ColorDocument colorDocument);

    public ColorDocument toDocument(Color color);

    public List<Color> toEntityList(List<ColorDocument> colorDocuments);

    public List<ColorDocument> toDocumentList(List<Color> colors);

}
