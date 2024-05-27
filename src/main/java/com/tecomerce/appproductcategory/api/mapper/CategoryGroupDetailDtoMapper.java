package com.tecomerce.appproductcategory.api.mapper;

import com.tecomerce.appproductcategory.api.service.dto.CategoryGroupDetailDTO;
import com.tecomerce.appproductcategory.domain.entity.CategoryGroupDetail;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryGroupDetailDtoMapper {

    public CategoryGroupDetail toEntity(CategoryGroupDetailDTO categoryGroupDetailDTO);

    public CategoryGroupDetailDTO toDto(CategoryGroupDetail categoryGroupDetail);

    public List<CategoryGroupDetail> toEntityList(List<CategoryGroupDetailDTO> categoryGroupDetailDTOS);

    public List<CategoryGroupDetailDTO> toDtoList(List<CategoryGroupDetail> categoryGroupDetails);
}