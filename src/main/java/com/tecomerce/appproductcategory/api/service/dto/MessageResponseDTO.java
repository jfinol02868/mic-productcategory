package com.tecomerce.appproductcategory.api.service.dto;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.ZonedDateTime;
import java.util.List;

public class MessageResponseDTO {

    @Schema(example = "E001")
    private String code;
    @Schema(example = "Message error description.")
    private String message;
    @ArraySchema(schema = @Schema( implementation = String.class))
    private List<String> details;
    @Schema(example = "2024-05-01T20:35:10")
    private ZonedDateTime timeStamp;
}
