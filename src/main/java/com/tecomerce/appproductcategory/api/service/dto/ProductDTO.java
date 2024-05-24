package com.tecomerce.appproductcategory.api.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tecomerce.appproductcategory.domain.valueobject.enums.EnumStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

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
    private MoneyDTO price;
    private Integer quantity;
    private Integer minimum;
    private Integer maximum;
    private EnumStatus stockStatus;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(description = "Date of creation",example = "2024-05-24T11:30:00-04:00")
    private ZonedDateTime createAt;




}
