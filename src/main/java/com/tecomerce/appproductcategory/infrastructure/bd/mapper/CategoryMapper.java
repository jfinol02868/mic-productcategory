package com.tecomerce.appproductcategory.infrastructure.bd.mapper;

import com.tecomerce.appproductcategory.domain.entity.Category;
import com.tecomerce.appproductcategory.domain.util.mapper.BaseMapper;
import com.tecomerce.appproductcategory.infrastructure.bd.document.CategoryDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<Category, CategoryDocument> {
}
