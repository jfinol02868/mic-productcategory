package com.tecomerce.appproductcategory.infrastructure.bd.document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@TypeAlias("image")
@Document(collection = "images")
public class ImageDocument {

    @Id
    private String id;
    private String name;
    private String title;
    private String code;
    private String type;
    private String size;
    private String url;
    private String path;
    private String extension;
    private String description;
    private String author;
    private ZonedDateTime createAt;
}
