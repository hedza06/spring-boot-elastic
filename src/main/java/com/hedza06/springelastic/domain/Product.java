package com.hedza06.springelastic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "product")
public class Product {

    @Id
    private String id;

    @Field(type = FieldType.Keyword, name = "primaryIdentifier")
    private String primaryIdentifier;

    @Field(type = FieldType.Text, name = "catalogName")
    private String catalogName;

    @Field(type = FieldType.Nested, includeInParent = true)
    private Category category;

    @Field(type = FieldType.Nested, includeInParent = true)
    private Customer customer;

    @Field(type = FieldType.Boolean, name = "isActive")
    private Boolean isActive = true;
}
