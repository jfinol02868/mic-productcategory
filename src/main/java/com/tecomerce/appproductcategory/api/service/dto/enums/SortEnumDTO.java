package com.tecomerce.appproductcategory.api.service.dto.enums;

import lombok.Getter;

@Getter
public enum SortEnumDTO {

    ASC("ASC"),
    DESC("DESC");

    private final String value;

    SortEnumDTO(String value) {
        this.value = value;
    }

}
