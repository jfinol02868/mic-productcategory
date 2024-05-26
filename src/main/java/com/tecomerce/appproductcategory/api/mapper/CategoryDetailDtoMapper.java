package com.tecomerce.appproductcategory.api.mapper;

import com.tecomerce.appproductcategory.api.service.dto.CategoryDetailDTO;
import com.tecomerce.appproductcategory.domain.entity.CategoryDetail;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryDetailDtoMapper {

    public CategoryDetail toEntity(CategoryDetailDTO categoryDetailDTO);

    public CategoryDetailDTO toDto(CategoryDetail categoryDetail);

    public List<CategoryDetail> toEntityList(List<CategoryDetailDTO> categoryDetailDTOS);

    public List<CategoryDetailDTO> toDtoList(List<CategoryDetail> categoryDetails);


}
