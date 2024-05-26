package com.tecomerce.appproductcategory.infrastructure.bd.repository;

import com.tecomerce.appproductcategory.infrastructure.bd.document.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepositoryAdapter extends MongoRepository<ProductDocument, String> {
}
