package com.tecomerce.appproductcategory.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Size {

    private String id;
    private String name;
    private String code;
    private String description;
    private String type;
    private String size;
}
