package com.tecomerce.appproductcategory.infrastructure.bd.mapper;

import com.tecomerce.appproductcategory.domain.entity.Product;
import com.tecomerce.appproductcategory.infrastructure.bd.document.ProductDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    public Product toEntity(ProductDocument productDocument);

    public ProductDocument toDocument(Product product);

    public List<Product> toEntityList(List<ProductDocument> productDocuments);

    public List<ProductDocument> toDocumentList(List<Product> products);
}
