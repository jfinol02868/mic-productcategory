package com.tecomerce.appproductcategory.domain.repository;

import com.tecomerce.appproductcategory.domain.entity.CategoryGroupDetail;

public interface CategoryGroupDetailRepository {

    default CategoryGroupDetail findCategoryGroupDetailById(String categoryId) { return null; }
}
