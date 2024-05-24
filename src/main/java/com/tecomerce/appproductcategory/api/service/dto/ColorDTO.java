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
public class ColorDTO {

    @Schema(description = "Color id", example = "PRODUCT::COLOR::BA0EE851-37C9-4518-A54F-FB69FCC6F891::DES")
    private String id;


    @Schema(description = "Color name", example = "Negro")
    @NotNull(message = "The name cannot be null or empty.")
    private String name;

    @NotNull(message = "The code cannot be null or empty.")
    @Schema(description = "Color code", example = "000001")
    private String code;

    @NotNull(message = "The hex cannot be null or empty.")
    @Schema(description = "Color hex", example = "#000000")
    private String hex;

    @Schema(description = "Color rgb", example = "0, 0%, 0%")
    private String rgb;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(description = "Date of creation",example = "2024-05-24T11:30:00-04:00")
    private ZonedDateTime createAt;
}
