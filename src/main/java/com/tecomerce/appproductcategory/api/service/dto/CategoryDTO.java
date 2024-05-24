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
public class CategoryDTO {

    @Schema(description = "Unique identifier of the category", example = "PRODUCT::CATEGORY::BA0EE851-37C9-4528-A54F-FB69FCC6F891::DES")
    private String id;

    @Schema(description = "Paren of the category", example = "Electronics")
    private Boolean isParent;

    @NotNull(message = "The name cannot be null or empty.")
    @Schema(description = "Name of the category", example = "Electronics")
    private String name;

    @Schema(description = "Description of the category", example = "Category for electronic devices")
    private String description;

    @Schema(description = "Identifier of the parent category", example = "PRODUCT::CATEGORY::BA0EE851-37C9-4528-A57F-FB69FCC6F891::DES")
    private String parentId;

    @Schema(description = "Status of the category", example = "ACTIVE")
    private String status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(description = "Date of creation", example = "2024-05-24T11:30:00-04:00")
    private ZonedDateTime createAt;
}
