package com.tecomerce.appproductcategory.domain.entity;

import com.tecomerce.appproductcategory.domain.valueobject.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
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
    private List<String> categories;
    private StatusEnum status;
    private ZonedDateTime createAt;

    public void dateOfCreation() {
        if(Objects.nonNull(this.createAt)) return;
        this.createAt = ZonedDateTime.now(ZoneId.of("UTC"));
    }

    public void initializationOfCategories(List<String> categories) {
        if(Objects.nonNull(this.categories)) return;
        this.categories = new ArrayList<>();
    }

}
