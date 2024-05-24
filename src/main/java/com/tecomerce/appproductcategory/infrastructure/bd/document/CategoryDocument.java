package com.tecomerce.appproductcategory.infrastructure.bd.document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

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
    private String parentId;
    private String status;
    private ZonedDateTime createAt;
}