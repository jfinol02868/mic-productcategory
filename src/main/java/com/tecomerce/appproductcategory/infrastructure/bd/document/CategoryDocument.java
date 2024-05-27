package com.tecomerce.appproductcategory.infrastructure.bd.document;

import com.tecomerce.appproductcategory.domain.valueobject.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("category")
@Document(collection = "categories")
public class CategoryDocument {

    @Id
    private String id;
    private Boolean isParent;
    private String name;
    private String description;
    private List<String> categories;
    private List<String> products;
    @Enumerated(EnumType.ORDINAL)
    private StatusEnum status;
    private ZonedDateTime createAt;
}