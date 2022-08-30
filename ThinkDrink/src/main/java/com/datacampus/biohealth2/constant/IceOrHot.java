package com.datacampus.biohealth2.constant;

public enum IceOrHot {
    HOT("HOT"),
    ICED("ICED");
    private final String ice_hot;
    IceOrHot(String ice_hot){
        this.ice_hot = ice_hot;
    }
    public String getIce_hot(){
        return ice_hot;
    }
}
