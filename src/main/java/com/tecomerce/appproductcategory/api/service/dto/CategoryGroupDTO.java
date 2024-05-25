package com.tecomerce.appproductcategory.api.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tecomerce.appproductcategory.api.service.dto.enums.StatusEnumDTO;
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
public class CategoryGroupDTO {

    @Schema(description = "Unique identifier of the category group", example = "GROUP::CATEGORY::A1B2C3D4-E5F6-7G8H-9I0J-K1L2M3N4O5P6")
    private String id;

    @NotNull(message = "The name cannot be null or empty.")
    @Schema(description = "Name of the category group", example = "Electronics Group")
    private String name;

    @Schema(description = "Code of the category group", example = "ELEC-GRP")
    private String code;

    @Schema(description = "Description of the category group", example = "Group for electronic categories")
    private String description;

    @Schema(description = "Name of the group", example = "Electronics")
    private String groupName;

    @Schema(description = "Status of the categoryGroup", example = "PUBLISHED")
    private StatusEnumDTO status;

    @Schema(description = "List of categories in this group")
    private List<String> categoryGroups;

    @Schema(description = "Indicates if the category group is active", example = "true")
    private boolean isActive;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(description = "Date of creation", example = "2024-05-24T11:30:00-04:00")
    private ZonedDateTime createAt;


}
