package com.tecomerce.appproductcategory.infrastructure.bd.mapper;

import com.tecomerce.appproductcategory.domain.entity.CategoryGroup;
import com.tecomerce.appproductcategory.infrastructure.bd.document.CategoryGroupDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryGroupMapper {

    public CategoryGroup toEntity(CategoryGroupDocument categoryGroupDocument);

    public CategoryGroupDocument toDocument(CategoryGroup categoryGroup);

    public List<CategoryGroup> toEntityList(List<CategoryGroupDocument> categoryGroupDocuments);

    public List<CategoryGroupDocument> toDocumentList(List<CategoryGroup> categoryGroups);
}
