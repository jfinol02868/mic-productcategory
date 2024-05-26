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
public class ImageDTO {

    @Schema(description = "Unique identifier of the image", example = "PRODUCT::IMAGE::ABC123DEF456::GHI789JKL012::DES")
    private String id;

    @NotNull(message = "The name cannot be null or empty.")
    @Schema(description = "Name of the image", example = "Sample Image")
    private String name;

    @Schema(description = "Title of the image", example = "A Beautiful Sunset")
    private String title;

    @NotNull(message = "The code cannot be null or empty.")
    @Schema(description = "Code of the image", example = "IMG001")
    private String code;

    @NotNull(message = "The type cannot be null or empty.")
    @Schema(description = "Type of image", example = "JPEG")
    private String type;

    @Schema(description = "Size of the image in bytes", example = "102400")
    private String size;

    @Schema(description = "URL of the image", example = "https://example.com/images/sample.jpg")
    private String url;

    @Schema(description = "Path where the image is stored", example = "/images/sample.jpg")
    private String path;

    @Schema(description = "File extension of the image", example = "jpg")
    private String extension;

    @Schema(description = "Description of the image", example = "A high-resolution image of a sunset over the mountains.")
    private String description;

    @Schema(description = "Author of the image", example = "John Doe")
    private String author;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(description = "Date of creation", example = "2024-05-24T11:30:00-04:00")
    private ZonedDateTime createAt;
}
