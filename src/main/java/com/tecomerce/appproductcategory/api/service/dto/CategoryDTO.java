package com.tecomerce.appproductcategory.api.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private String id;
    private String name;
    private String description;
    private String parentId;
    private String status;
}
