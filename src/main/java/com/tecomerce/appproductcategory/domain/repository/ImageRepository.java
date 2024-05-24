package com.tecomerce.appproductcategory.domain.repository;

import com.tecomerce.appproductcategory.api.service.dto.enums.SortEnum;
import com.tecomerce.appproductcategory.domain.entity.Image;

import java.util.List;

public interface ImageRepository extends BaseRepository<Image, String> {

    public List<Image> filters(Image image, int page, int size, String direction, String... sortProperties);
}
