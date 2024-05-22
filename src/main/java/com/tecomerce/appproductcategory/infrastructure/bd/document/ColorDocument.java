package com.tecomerce.appproductcategory.infrastructure.bd.document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ColorDocument {

    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String code;
    private String hex;
    private String rgb;
}
