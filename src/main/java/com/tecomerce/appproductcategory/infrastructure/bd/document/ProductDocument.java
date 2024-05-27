package com.tecomerce.appproductcategory.infrastructure.bd.document;

import com.tecomerce.appproductcategory.domain.entity.Money;
import com.tecomerce.appproductcategory.domain.valueobject.enums.EnumStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TypeAlias("product")
@Document(collection = "products")
public class ProductDocument {

    @Id
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
    private ZonedDateTime createAt;
}
