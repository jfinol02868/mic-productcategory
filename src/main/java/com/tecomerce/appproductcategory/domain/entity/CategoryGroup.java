package com.tecomerce.appproductcategory.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tecomerce.appproductcategory.api.service.dto.enums.StatusEnumDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryGroup {

    private String id;
    private String name;
    private String code;
    private String description;
    private String groupName;
    private StatusEnumDTO status;
    private List<String> categoryGroups;
    private Boolean active;
    private ZonedDateTime createAt;

    public void dateOfCreation() {
        if(Objects.nonNull(this.createAt)) return;
        this.createAt = ZonedDateTime.now(ZoneId.of("UTC"));
    }
}
