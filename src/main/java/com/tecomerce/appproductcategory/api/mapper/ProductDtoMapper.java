package com.tecomerce.appproductcategory.api.mapper;

import com.tecomerce.appproductcategory.api.service.dto.ProductDTO;
import com.tecomerce.appproductcategory.domain.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductDtoMapper {

    public Product toEntity(ProductDTO productDTO);

    public ProductDTO toDto(Product product);

    public List<Product> toEntityList(List<ProductDTO> productDTOS);

    public List<ProductDTO> toDtoList(List<Product> products);
}
