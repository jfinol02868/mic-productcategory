package com.tecomerce.appproductcategory.infrastructure.bd.repository;

import com.tecomerce.appproductcategory.infrastructure.bd.document.LocationDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepositoryAdapter extends MongoRepository<LocationDocument, String>{
}
