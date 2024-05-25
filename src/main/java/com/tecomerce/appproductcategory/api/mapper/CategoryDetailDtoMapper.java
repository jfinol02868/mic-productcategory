package com.tecomerce.appproductcategory.api.mapper;

import com.tecomerce.appproductcategory.api.service.dto.CategoryDetailDTO;
import com.tecomerce.appproductcategory.domain.entity.CategoryDetail;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryDetailDtoMapper {

    public CategoryDetail toEntity(CategoryDetailDTO categoryDocument);

    public CategoryDetailDTO toDto(CategoryDetail category);

    public List<CategoryDetail> toEntityList(List<CategoryDetailDTO> categoryDocuments);

    public List<CategoryDetailDTO> toDtoList(List<CategoryDetail> categories);


}
