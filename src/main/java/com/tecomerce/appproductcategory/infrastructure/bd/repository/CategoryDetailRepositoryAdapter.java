package com.tecomerce.appproductcategory.infrastructure.bd.repository;

import com.tecomerce.appproductcategory.infrastructure.bd.document.CategoryDetailDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryDetailRepositoryAdapter extends MongoRepository<CategoryDetailDocument, String> {
}
