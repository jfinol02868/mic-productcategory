package com.tecomerce.appproductcategory.infrastructure.bd.document;

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

    private String id;
    private String currency;
    private BigDecimal amount;

}
