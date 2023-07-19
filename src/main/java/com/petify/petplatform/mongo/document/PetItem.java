package com.petify.petplatform.mongo.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("pets")
@Data
public class PetItem {

    @Id
    private String id;

    private String name;
    private Integer age;
    private String category;
}
