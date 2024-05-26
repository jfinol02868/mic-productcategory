package com.tecomerce.appproductcategory.infrastructure.bd.repository;

import com.tecomerce.appproductcategory.infrastructure.bd.document.CategoryGroupDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryGroupRepositoryAdapter extends MongoRepository<CategoryGroupDocument, String> {
}
