package com.tecomerce.appproductcategory.infrastructure.bd.repository;

import com.tecomerce.appproductcategory.infrastructure.bd.document.ColorDocument;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ColorRepositoryAdapter extends MongoRepository<ColorDocument, String>{

    public List<ColorDocument> findAll(Query query);
}
