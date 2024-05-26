package com.tecomerce.appproductcategory.api.service.dto.enums;

import lombok.Getter;

@Getter
public enum StatusEnumDTO {

    ENABLED("ENABLED"),
    DISABLED("DISABLED"),
    PUBLISHED("PUBLISHED"),
    UNPUBLISHED("UNPUBLISHED");

    private final String value;

    StatusEnumDTO(String value) {
        this.value = value;
    }
}
