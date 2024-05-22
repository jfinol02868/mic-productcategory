package com.tecomerce.appproductcategory.api.mapper;

import com.tecomerce.appproductcategory.api.service.dto.ProductDTO;
import com.tecomerce.appproductcategory.domain.entity.Product;
import com.tecomerce.appproductcategory.domain.util.mapper.BaseDtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseDtoMapper<Product, ProductDTO> {
}
