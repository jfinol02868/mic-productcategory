package com.tecomerce.appproductcategory.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tecomerce.appproductcategory.api.service.dto.enums.StatusEnumDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryGroupDetail {

    private String id;
    private String name;
    private String code;
    private String description;
    private String groupName;
    private StatusEnumDTO status;
    private List<Category> categoryGroups;
    private boolean active;
    private ZonedDateTime createAt;
}
