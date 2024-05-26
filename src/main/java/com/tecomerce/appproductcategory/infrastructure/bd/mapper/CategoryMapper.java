package com.tecomerce.appproductcategory.infrastructure.bd.mapper;

import com.tecomerce.appproductcategory.domain.entity.Category;
import com.tecomerce.appproductcategory.infrastructure.bd.document.CategoryDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    public Category toEntity(CategoryDocument categoryDocument);

    public CategoryDocument toDocument(Category category);

    public List<Category> toEntityList(List<CategoryDocument> categoryDocuments);

    public List<CategoryDocument> toDocumentList(List<Category> categories);
}
