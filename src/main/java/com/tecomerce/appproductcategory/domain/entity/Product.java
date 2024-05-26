package com.tecomerce.appproductcategory.domain.entity;

import com.tecomerce.appproductcategory.domain.valueobject.enums.EnumStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String id;
    private String name;
    private String description;
    private Boolean status;
    private String weight;
    private String brand;
    private String model;
    private String sku;
    private String upc;
    private String ean;
    private String jan;
    private String isbn;
    private List<String> image;
    private List<String> color;
    private List<String> size;
    private List<String> categories;
    private List<String> location;
    private Money price;
    private Integer quantity;
    private Integer minimum;
    private Integer maximum;
    private EnumStatus stockStatus;
    private ZonedDateTime createAt;

    public void dateOfCreation() {
        if(Objects.nonNull(this.createAt)) return;
        this.createAt = ZonedDateTime.now(ZoneId.of("UTC"));
    }
}
