package com.tecomerce.appproductcategory.infrastructure.bd.mapper;

import com.tecomerce.appproductcategory.domain.entity.Product;
import com.tecomerce.appproductcategory.domain.util.mapper.BaseMapper;
import com.tecomerce.appproductcategory.infrastructure.bd.document.ProductDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<Product, ProductDocument> {
}
