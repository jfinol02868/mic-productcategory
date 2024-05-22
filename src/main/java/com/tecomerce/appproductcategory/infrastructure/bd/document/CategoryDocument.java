package com.tecomerce.appproductcategory.infrastructure.bd.document;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CategoryDocument {

    private String id;
    private String name;
    private String description;
    private String parentId;
    private String status;
}