package com.tecomerce.appproductcategory.infrastructure.bd.document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("color")
@Document(collection = "colors")
public class ColorDocument {

    @Id
    private String id;
    private String name;
    private String code;
    private String hex;
    private String rgb;
}
