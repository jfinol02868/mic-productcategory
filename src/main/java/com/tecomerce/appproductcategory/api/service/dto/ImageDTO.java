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
@AllArgsConstructor
@NoArgsConstructor
public class ImageDTO {

    private String id;
    private String name;
    private String title;
    private String code;
    private String type;
    private String size;
    private String url;
    private String path;
    private String extension;
    private String description;
    private String author;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(description = "Date of creation",example = "2024-05-24T11:30:00-04:00")
    private ZonedDateTime createAt;
}
