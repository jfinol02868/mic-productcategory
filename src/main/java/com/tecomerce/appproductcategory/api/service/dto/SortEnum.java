package com.tecomerce.appproductcategory.api.service.dto;

import lombok.Getter;

@Getter
public enum SortEnum {

    ASC("ASC"),
    DESC("DESC");

    private final String value;

    SortEnum(String value) {
        this.value = value;
    }

}
