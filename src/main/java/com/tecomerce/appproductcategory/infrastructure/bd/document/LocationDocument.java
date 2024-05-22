package com.tecomerce.appproductcategory.infrastructure.bd.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationDocument {

    private String id;
    private String code;
    private String name;
    private String description;
}
