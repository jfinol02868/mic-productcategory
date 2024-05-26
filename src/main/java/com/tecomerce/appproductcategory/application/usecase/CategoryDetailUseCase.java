package com.tecomerce.appproductcategory.application.usecase;

import com.tecomerce.appproductcategory.domain.entity.CategoryDetail;

public interface CategoryDetailUseCase {

    default CategoryDetail findCategoryDetailByCategoryId(String categoryId) { return null; }
}
