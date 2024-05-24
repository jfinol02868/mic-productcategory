package com.tecomerce.appproductcategory.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    private String id;
    private Boolean isParent;
    private String name;
    private String description;
    private String parentId;
    private String status;
    private ZonedDateTime createAt;

    public void dateOfCreation() {
        if(Objects.nonNull(this.createAt)) return;
        this.createAt = ZonedDateTime.now(ZoneId.of("UTC"));
    }
}
