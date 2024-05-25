package com.tecomerce.appproductcategory.domain.entity;

import com.tecomerce.appproductcategory.domain.valueobject.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDetail {


    private String id;
    private Boolean isParent;
    private String name;
    private String description;
    private List<CategoryDetail> categories;
    private StatusEnum status;
    private ZonedDateTime createAt;
}
