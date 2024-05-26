package com.tecomerce.appproductcategory.api.mapper;

import com.tecomerce.appproductcategory.api.service.dto.ImageDTO;
import com.tecomerce.appproductcategory.domain.entity.Image;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageDtoMapper {

    public Image toEntity(ImageDTO imageDTO);

    public ImageDTO toDto(Image image);

    public List<Image> toEntityList(List<ImageDTO> imageDTOS);

    public List<ImageDTO> toDtoList(List<Image> images);
}
