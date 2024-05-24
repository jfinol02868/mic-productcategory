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
@AllArgsConstructor
@NoArgsConstructor
public class Size {

    private String id;
    private String name;
    private String code;
    private String description;
    private String type;
    private String size;
    private ZonedDateTime createAt;

    public void dateOfCreation() {
        if(Objects.nonNull(this.createAt)) return;
        this.createAt = ZonedDateTime.now(ZoneId.of("UTC"));
    }
}
