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
@AllArgsConstructor
@NoArgsConstructor
@TypeAlias("size")
@Document(collection = "sizes")
public class SizeDocument {

    @Id
    private String id;
    private String name;
    private String code;
    private String description;
    private String type;
    private String size;
    private ZonedDateTime createAt;
}
