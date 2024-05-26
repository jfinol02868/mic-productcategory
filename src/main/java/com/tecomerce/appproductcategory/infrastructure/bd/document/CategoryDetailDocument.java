package com.tecomerce.appproductcategory.infrastructure.bd.document;

import com.tecomerce.appproductcategory.domain.valueobject.enums.StatusEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
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
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "categories")
public class CategoryDetailDocument {

    @Id
    private String id;
    private Boolean isParent;
    private String name;
    private String description;
    @DocumentReference(collection = "categories", lazy = true)
    private List<CategoryDetailDocument> categories;
    @Enumerated(EnumType.ORDINAL)
    private StatusEnum status;
    private ZonedDateTime createAt;
}
