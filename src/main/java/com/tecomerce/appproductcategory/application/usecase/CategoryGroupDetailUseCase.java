package com.tecomerce.appproductcategory.application.usecase;

import com.tecomerce.appproductcategory.domain.entity.CategoryGroupDetail;

public interface CategoryGroupDetailUseCase {

    default CategoryGroupDetail findCategoryGroupDetailById(String categoryId) { return null; }
}
