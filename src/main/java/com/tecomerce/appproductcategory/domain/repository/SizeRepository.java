package com.tecomerce.appproductcategory.domain.repository;

import com.tecomerce.appproductcategory.domain.entity.Size;

import java.util.List;

public interface SizeRepository extends BaseRepository<Size, String> {

    public List<Size> filterSize(String id, String name, String code, String description, String type, String size,
                                 int page, int records, String direction, String... properties);
}
