package com.hedza06.springelastic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "customer")
public class Customer {

    @Id
    private String id;

    @Field(type = FieldType.Keyword, name = "primaryIdentifier")
    private String primaryIdentifier;

    @Field(type = FieldType.Text, name = "fullName")
    private String fullName;

    @Field(type = FieldType.Date, name = "createdAt")
    private Date createdAt;

    @Field(type = FieldType.Boolean, name = "isActive")
    private Boolean isActive = true;
}
