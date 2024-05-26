package com.tecomerce.appproductcategory.application.usecase;

import com.tecomerce.appproductcategory.domain.entity.Image;

import java.util.List;

public interface ImageUseCase extends BaseUseCase<Image, String> {

    public List<Image> filters(String filterProperties, int page, int size, String direction, String... sortProperties);
}
