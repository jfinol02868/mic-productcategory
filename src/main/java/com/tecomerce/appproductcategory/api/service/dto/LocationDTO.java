package com.tecomerce.appproductcategory.api.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {

    private String id;
    private String code;
    private String name;
    private String description;
}
