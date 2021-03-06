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
@Document(indexName = "call")
public class Call {

    @Id
    private String id;

    @Field(type = FieldType.Text, name = "note")
    private String note;

    @Field(includeInParent = true)
    private Customer customer;

    @Field(includeInParent = true)
    private Product product;
}
