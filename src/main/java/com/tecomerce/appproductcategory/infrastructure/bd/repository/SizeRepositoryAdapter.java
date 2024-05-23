package com.tecomerce.appproductcategory.infrastructure.bd.repository;

import com.tecomerce.appproductcategory.infrastructure.bd.document.SizeDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepositoryAdapter extends JpaRepository<SizeDocument, Long> {
}
