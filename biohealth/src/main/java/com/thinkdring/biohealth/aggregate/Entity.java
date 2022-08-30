package com.thinkdring.biohealth.aggregate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
public abstract class Entity {
    //

    protected String id;

    protected Entity() {
        //
        this.id = UUID.randomUUID().toString();
    }

    protected Entity(String id) {
        //
        this.id = id;
    }
}
