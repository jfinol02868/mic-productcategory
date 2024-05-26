package com.tecomerce.appproductcategory.api.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tecomerce.appproductcategory.domain.valueobject.enums.EnumStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
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

    @Schema(description = "Unique identifier of the product", example = "PRODUCT::PRODUCT::BA0EE851-37C9-4518-A54F-FB69FCC6F891::DES")
    private String id;

    @NotNull(message = "The name cannot be null or empty.")
    @Schema(description = "Name of the product", example = "Smartphone")
    private String name;

    @Schema(description = "Description of the product", example = "Latest model smartphone with advanced features")
    private String description;

    @Schema(description = "Status of the product availability", example = "true")
    private Boolean status;

    @Schema(description = "Weight of the product in grams", example = "150g")
    private String weight;

    @Schema(description = "Brand of the product", example = "TechBrand")
    private String brand;

    @Schema(description = "Model of the product", example = "X123")
    private String model;

    @Schema(description = "SKU (Stock Keeping Unit) of the product", example = "SKU123456")
    private String sku;

    @Schema(description = "UPC (Universal Product Code) of the product", example = "123456789012")
    private String upc;

    @Schema(description = "EAN (European Article Number) of the product", example = "1234567890123")
    private String ean;

    @Schema(description = "JAN (Japanese Article Number) of the product", example = "12345678901234")
    private String jan;

    @Schema(description = "ISBN (International Standard Book Number) of the product", example = "978-3-16-148410-0")
    private String isbn;

    @Schema(description = "List of image URLs for the product", example = "[\"http://example.com/image1.jpg\", \"http://example.com/image2.jpg\"]")
    private List<String> image;

    @Schema(description = "List of available colors for the product", example = "[\"Red\", \"Blue\"]")
    private List<String> color;

    @Schema(description = "List of available sizes for the product", example = "[\"Small\", \"Medium\", \"Large\"]")
    private List<String> size;

    @Schema(description = "List of categories the product belongs to", example = "[\"Electronics\", \"Mobile Phones\"]")
    private List<String> categories;

    @Schema(description = "List of locations where the product is available", example = "[\"Warehouse A\", \"Store B\"]")
    private List<String> location;

    @Schema(description = "Quantity of the product in stock", example = "100")
    private Integer quantity;

    @Schema(description = "Minimum quantity of the product in stock", example = "10")
    private Integer minimum;

    @Schema(description = "Maximum quantity of the product in stock", example = "200")
    private Integer maximum;

    @Schema(description = "Stock status of the product", example = "IN_STOCK")
    private EnumStatus stockStatus;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(description = "Date of creation", example = "2024-05-24T11:30:00-04:00")
    private ZonedDateTime createAt;
}
