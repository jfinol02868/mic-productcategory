package com.tecomerce.appproductcategory.infrastructure.bd.repository;

import com.tecomerce.appproductcategory.infrastructure.bd.document.CategoryDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepositoryAdapter extends MongoRepository<CategoryDocument, String> {
}
