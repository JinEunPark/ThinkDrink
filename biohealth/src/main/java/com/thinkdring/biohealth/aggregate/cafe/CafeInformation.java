package com.thinkdring.biohealth.aggregate.cafe;

import com.thinkdring.biohealth.aggregate.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CafeInformation extends Entity {
    private String cafeName;
    //Constructor 1
    public CafeInformation(String cafeName, String cafeId){
        super(cafeId);

        this.cafeName = cafeName;
    }
    //constructor2
    public CafeInformation(String cafeName){
        super();
        this.cafeName = cafeName;
    }

}
