package com.tecomerce.appproductcategory.domain.valueobject.enums;

import lombok.Getter;

@Getter
public enum MessageEnum {
    ENTITY_NOT_FOUND("Entity not found"),
    METHOD_ARGUMENT_NOT_VALID("Argument not valid"),
    GENERIC_ERROR("Generic error");

    private final String message;

    MessageEnum(String message) {
        this.message = message;
    }
}
