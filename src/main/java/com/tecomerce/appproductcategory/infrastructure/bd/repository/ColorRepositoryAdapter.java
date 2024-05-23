package com.tecomerce.appproductcategory.infrastructure.bd.repository;

import com.tecomerce.appproductcategory.infrastructure.bd.document.ColorDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ColorRepositoryAdapter extends MongoRepository<ColorDocument, String>{

}
