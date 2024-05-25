package com.tecomerce.appproductcategory.domain.valueobject.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {

    ENABLED("ENABLED"),
    DISABLED("DISABLED"),
    PUBLISHED("PUBLISHED"),
    UNPUBLISHED("UNPUBLISHED");

    private final String value;

    StatusEnum(String value) {
        this.value = value;
    }
}
