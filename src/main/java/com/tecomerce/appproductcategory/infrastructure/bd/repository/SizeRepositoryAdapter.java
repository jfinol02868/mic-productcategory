package com.tecomerce.appproductcategory.infrastructure.bd.repository;

import com.tecomerce.appproductcategory.infrastructure.bd.document.SizeDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SizeRepositoryAdapter extends MongoRepository<SizeDocument, String> {


}
