package com.tecomerce.appproductcategory.infrastructure.bd.document;

import com.tecomerce.appproductcategory.api.service.dto.enums.StatusEnumDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TypeAlias("categoryGroup")
@Document(collection = "categoryGroups")
public class CategoryGroupDocument {

    private String id;
    private String name;
    private String code;
    private String description;
    private String groupName;
    private StatusEnumDTO status;
    private List<String> categoryGroups;
    private boolean active;
    private ZonedDateTime createAt;
}
