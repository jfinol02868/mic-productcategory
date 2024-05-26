package com.tecomerce.appproductcategory.infrastructure.bd.mapper;

import com.tecomerce.appproductcategory.domain.entity.Image;
import com.tecomerce.appproductcategory.infrastructure.bd.document.ImagesDocuments;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    public Image toEntity(ImagesDocuments imagesDocuments);

    public ImagesDocuments toDocument(Image image);

    public List<Image> toEntityList(List<ImagesDocuments> imagesDocuments);

    public List<ImagesDocuments> toDocumentList(List<Image> images);
}
