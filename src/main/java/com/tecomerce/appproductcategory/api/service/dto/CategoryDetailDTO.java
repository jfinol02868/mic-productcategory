package com.tecomerce.appproductcategory.api.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tecomerce.appproductcategory.api.service.dto.enums.StatusEnumDTO;
import com.tecomerce.appproductcategory.domain.valueobject.enums.StatusEnum;
import io.swagger.v3.oas.annotations.media.ArraySchema;
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
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDetailDTO {

    @Schema(description = "Unique identifier of the category", example = "PRODUCT::CATEGORY::BA0EE851-37C9-4528-A54F-FB69FCC6F891::DES")
    private String id;

    @Schema(description = "Parent of the category", example = "Electronics")
    private Boolean isParent;

    @NotNull(message = "The name cannot be null or empty.")
    @Schema(description = "Name of the category", example = "Electronics")
    private String name;

    @Schema(description = "Description of the category", example = "Category for electronic devices")
    private String description;

    @ArraySchema(schema = @Schema(implementation = CategoryDetailDTO.class))
    private List<CategoryDetailDTO> categories;

    @ArraySchema(schema = @Schema(implementation = ProductDTO.class))
    private List<ProductDTO> products;

    @Schema(description = "Status of the category", example = "PUBLISHED")
    private StatusEnumDTO status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(description = "Date of creation", example = "2024-05-24T11:30:00-04:00")
    private ZonedDateTime createAt;
}
