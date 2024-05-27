package com.tecomerce.appproductcategory.infrastructure.bd.document;

import com.tecomerce.appproductcategory.api.service.dto.enums.StatusEnumDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "categoryGroups")
public class CategoryGroupDetailDocument {

    private String id;
    private String name;
    private String code;
    private String description;
    private String groupName;
    private StatusEnumDTO status;
    @DocumentReference(collection = "categories", lazy = true)
    private List<CategoryDocument> categoryGroups;
    private boolean isActive;
    private ZonedDateTime createAt;
}
