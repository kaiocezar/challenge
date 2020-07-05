package com.labs.challenge.entities;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;


@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AbstractEntity(){
        id = UUID.randomUUID().toString();
    }

}
