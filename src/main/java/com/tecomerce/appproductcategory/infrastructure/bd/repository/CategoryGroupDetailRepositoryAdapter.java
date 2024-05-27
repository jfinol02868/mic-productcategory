package com.tecomerce.appproductcategory.infrastructure.bd.repository;

import com.tecomerce.appproductcategory.infrastructure.bd.document.CategoryGroupDetailDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryGroupDetailRepositoryAdapter extends MongoRepository<CategoryGroupDetailDocument, String> {
}
