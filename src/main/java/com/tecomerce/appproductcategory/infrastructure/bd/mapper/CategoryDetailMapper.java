package com.tecomerce.appproductcategory.infrastructure.bd.mapper;

import com.tecomerce.appproductcategory.domain.entity.CategoryDetail;
import com.tecomerce.appproductcategory.infrastructure.bd.document.CategoryDetailDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryDetailMapper {

    public CategoryDetail toEntity(CategoryDetailDocument categoryDocument);

    public CategoryDetailDocument toDocument(CategoryDetail category);

    public List<CategoryDetail> toEntityList(List<CategoryDetailDocument> categoryDocuments);

    public List<CategoryDetailDocument> toDocumentList(List<CategoryDetail> categories);


}
