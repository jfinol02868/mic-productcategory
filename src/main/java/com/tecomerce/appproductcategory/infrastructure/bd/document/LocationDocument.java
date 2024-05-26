package com.tecomerce.appproductcategory.infrastructure.bd.document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("location")
@Document(collection = "locations")
public class LocationDocument {

    @Id
    private String id;
    private String code;
    private String name;
    private String description;
    private ZonedDateTime createAt;
}
