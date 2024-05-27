package com.tecomerce.appproductcategory.infrastructure.bd.mapper;

import com.tecomerce.appproductcategory.api.service.dto.CategoryGroupDetailDTO;
import com.tecomerce.appproductcategory.domain.entity.CategoryGroupDetail;
import com.tecomerce.appproductcategory.infrastructure.bd.document.CategoryGroupDetailDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryGroupDetailMapper {

    public CategoryGroupDetail toEntity(CategoryGroupDetailDocument categoryGroupDetailDocument);

    public CategoryGroupDetailDocument toDto(CategoryGroupDetail categoryGroupDetail);

    public List<CategoryGroupDetail> toEntityList(List<CategoryGroupDetailDocument> categoryGroupDetailDocuments);

    public List<CategoryGroupDetailDocument> toDtoList(List<CategoryGroupDetail> categoryGroupDetails);
}