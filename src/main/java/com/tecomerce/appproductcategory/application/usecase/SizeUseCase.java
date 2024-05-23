package com.tecomerce.appproductcategory.application.usecase;

import com.tecomerce.appproductcategory.api.service.dto.enums.SortEnum;
import com.tecomerce.appproductcategory.domain.entity.Size;

import java.util.List;

public interface SizeUseCase extends BaseUseCase<Size, String> {
    
    public List<Size> filterSize( String id, String name, String code, String description, String type, String size,
                                       int page, int records, String direction, String... properties);
}
