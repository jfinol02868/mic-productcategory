package com.tecomerce.appproductcategory.infrastructure.bd.mapper;

import com.tecomerce.appproductcategory.domain.entity.CategoryDetail;
import com.tecomerce.appproductcategory.infrastructure.bd.document.CategoryDetailDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryDetailMapper {

    public CategoryDetail toEntity(CategoryDetailDocument categoryDetailDocument);

    public CategoryDetailDocument toDocument(CategoryDetail categoryDetail);

    public List<CategoryDetail> toEntityList(List<CategoryDetailDocument> categoryDetailDocuments);

    public List<CategoryDetailDocument> toDocumentList(List<CategoryDetail> categoryDetails);


}
