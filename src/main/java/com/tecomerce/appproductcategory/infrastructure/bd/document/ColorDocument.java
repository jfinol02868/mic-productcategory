package com.tecomerce.appproductcategory.infrastructure.bd.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ColorDocument {

    private String id;
    private String name;
    private String code;
    private String hex;
    private String rgb;
}
