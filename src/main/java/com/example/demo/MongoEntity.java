package com.example.demo;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "aliens")
@Getter
@Setter
public class MongoEntity {

    @Id
    private String id;

    private String name;
    private String tech;
    private boolean sub;
    //private Date createdAt;
    //private Date updatedAt;

    public MongoEntity() {
    }
}
