package com.datacampus.biohealth2.constant;

public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE");
    private final String gender;
    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

}
