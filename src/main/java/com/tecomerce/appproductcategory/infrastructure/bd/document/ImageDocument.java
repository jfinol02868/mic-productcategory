package com.tecomerce.appproductcategory.infrastructure.bd.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageDocument {

    private String id;
    private String name;
    private String title;
    private String code;
    private String type;
    private String size;
    private String url;
    private String path;
    private String extension;
    private String description;
    private String author;
}
