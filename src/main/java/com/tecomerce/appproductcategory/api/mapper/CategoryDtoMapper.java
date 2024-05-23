package com.tecomerce.appproductcategory.api.mapper;

import com.tecomerce.appproductcategory.api.service.dto.CategoryDTO;
import com.tecomerce.appproductcategory.domain.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryDtoMapper {

    public Category toEntity(CategoryDTO categoryDTO);

    public CategoryDTO toDto(Category category);

    public List<Category> toEntityList(List<CategoryDTO> categoryDTOS);

    public List<CategoryDTO> toDtoList(List<Category> categories);
}
