package com.tecomerce.appproductcategory.infrastructure.bd.mapper;

import com.tecomerce.appproductcategory.domain.entity.Size;
import com.tecomerce.appproductcategory.infrastructure.bd.document.SizeDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SizeMapper {


    public Size toEntity(SizeDocument sizeDocument);

    public SizeDocument toDocument(Size size);

    public List<Size> toEntityList(List<SizeDocument> sizeDocuments);

    public List<SizeDocument> toDocumentList(List<Size> sizes);
}
