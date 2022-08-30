package com.thinkdring.biohealth.aggregate.user;

import com.thinkdring.biohealth.aggregate.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor

public class Profile extends Entity {

    private String userName;
    private String userId;//user가 설정한 ID
    private String password;
    private String email;
    private long foundation_Time;

    //constructor 1
    public Profile(String userId, String password, String email, Date foundation_Time, String userName) {
        super();
        this.userId = userId;
        this.password = password;
        this.email = email;;lskdj;flkaj;sdf
        this.foundation_Time = System.currentTimeMillis();
        this.userName = userName;
    }
    //constructor 2
    public Profile(String idFromAutocreated, String userId, String password, String email, Date foundation_Time, String userName) {
        super(idFromAutocreated);
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.foundation_Time = System.currentTimeMillis();
        this.userName = userName;
    }

    public boolean checkValidation(String name){
         if(name.length()<2) {
             return false;
         }else{
             return true;
         }
    }
}
