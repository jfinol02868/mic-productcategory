package com.tecomerce.appproductcategory.infrastructure.bd.document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MoneyDocument {

    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String currency;
    private BigDecimal amount;

}
