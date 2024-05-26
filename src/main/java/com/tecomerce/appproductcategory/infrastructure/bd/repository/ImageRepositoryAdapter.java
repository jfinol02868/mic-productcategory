package com.tecomerce.appproductcategory.infrastructure.bd.repository;

import com.tecomerce.appproductcategory.infrastructure.bd.document.ImagesDocuments;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepositoryAdapter extends MongoRepository<ImagesDocuments, String> {
}