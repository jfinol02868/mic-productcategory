package com.tecomerce.appproductcategory.infrastructure.bd.repository;

import com.tecomerce.appproductcategory.infrastructure.bd.document.ImageDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepositoryAdapter extends JpaRepository<ImageDocument, String>{
}
