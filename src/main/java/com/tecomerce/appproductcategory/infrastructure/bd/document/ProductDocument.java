package com.tecomerce.appproductcategory.infrastructure.bd.document;

import com.tecomerce.appproductcategory.domain.entity.Money;
import com.tecomerce.appproductcategory.domain.valueobject.enums.EnumStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDocument {

    @GeneratedValue(strategy = GenerationType.UUID)
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
    @Enumerated(EnumType.STRING)
    private EnumStatus stockStatus;




}
