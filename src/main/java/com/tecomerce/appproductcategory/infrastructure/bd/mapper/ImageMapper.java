package com.tecomerce.appproductcategory.infrastructure.bd.mapper;

import com.tecomerce.appproductcategory.domain.entity.Image;
import com.tecomerce.appproductcategory.infrastructure.bd.document.ImageDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    public Image toEntity(ImageDocument imageDocument);

    public ImageDocument toDocument(Image image);

    public List<Image> toEntityList(List<ImageDocument> imageDocuments);

    public List<ImageDocument> toDocumentList(List<Image> images);
}
