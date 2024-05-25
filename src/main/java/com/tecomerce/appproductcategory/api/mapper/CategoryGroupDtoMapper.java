package com.tecomerce.appproductcategory.api.mapper;

import com.tecomerce.appproductcategory.api.service.dto.CategoryGroupDTO;
import com.tecomerce.appproductcategory.domain.entity.CategoryGroup;
import com.tecomerce.appproductcategory.infrastructure.bd.document.CategoryGroupDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryGroupDtoMapper {

    public CategoryGroup toEntity(CategoryGroupDTO categoryGroupDTO);

    public CategoryGroupDTO toDto(CategoryGroup categoryGroup);

    public List<CategoryGroup> toEntityList(List<CategoryGroupDTO> categoryGroupDTOS);

    public List<CategoryGroupDTO> toDtoList(List<CategoryGroup> categoryGroups);
}
