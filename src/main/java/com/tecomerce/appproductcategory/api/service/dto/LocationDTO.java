package com.tecomerce.appproductcategory.api.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {

    @Schema(description = "Unique identifier of the location", example = "PRODUCT::LOCATION::ABC123DEF456::GHI789JKL012::DES")
    private String id;

    @Schema(description = "Code of the location", example = "A1")
    private String code;

    @Schema(description = "Name of the location", example = "Shelf A")
    private String name;

    @Schema(description = "Description of the location", example = "First shelf on the left at the main entrance.")
    private String description;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(description = "Date of creation", example = "2024-05-24T11:30:00-04:00")
    private ZonedDateTime createAt;
}
