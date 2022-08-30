package com.thinkdring.biohealth.aggregate.user;

import com.thinkdring.biohealth.aggregate.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter

public class HealthInformation extends Entity {

//    private String userId = new Profile().getUserId();

    private String name;
    private double height;
    private double weight;
    private boolean gender;// ture == female
    private Date foundationTime;//make == date of make this profile
    private String personId;
    //constructor1
    public HealthInformation(String name, double height, double weight, boolean gender,String personId) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.foundationTime = new Date();
        this.personId = personId;
    }
    //constructor2
    public HealthInformation(String id, String name, double height, double weight, boolean gender, String personId) {
        super(id);
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.foundationTime = new Date();
        this.personId = personId;
    }
    //Type for the activity
    public static enum Type{//

        FIRST,
        SECOND,
        THIRD,
        FORTH
    }


}
