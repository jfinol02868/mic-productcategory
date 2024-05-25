package com.tecomerce.appproductcategory.domain.repository;

import com.tecomerce.appproductcategory.domain.entity.CategoryDetail;

public interface CategoryDetailRepository {

    default CategoryDetail findCategoryDetailByCategoryId(String categoryId) { return null; }
}
