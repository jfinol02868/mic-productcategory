package com.tecomerce.appproductcategory.api.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SizeDTO {

    @Schema(description = "Unique identifier of the size", example = "PRODUCT::COLOR::BA0EE851-37C9-4518-A54F-FB69FCC6F891::DES")
    private String id;

    @NotNull(message = "The name cannot be null or empty.")
    @Schema(description = "Name of the size", example = "Large")
    private String name;

    @NotNull(message = "The code cannot be null or empty.")
    @Schema(description = "Code of the size", example = "L")
    private String code;

    @Schema(description = "Description of the size", example = "Large size for adults")
    private String description;

    @NotNull(message = "The type cannot be null or empty.")
    @Schema(description = "Type of size", example = "Clothing")
    private String type;

    @NotNull(message = "The size cannot be null or empty.")
    @Schema(description = "Specific size value", example = "42")
    private String size;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(description = "Date of creation",example = "2024-05-24T11:30:00-04:00")
    private ZonedDateTime createAt;
}
