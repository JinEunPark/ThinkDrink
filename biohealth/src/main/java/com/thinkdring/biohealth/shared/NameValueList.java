package com.thinkdring.biohealth.shared;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
public class NameValueList {
    //
    private List<NameValue> nameValues;

    public NameValueList() {
        //
        this.nameValues = new ArrayList<NameValue>();
    }

    public void addNameValue(String name, String value) {
        //
        NameValue nameValue = new NameValue(name, value);
        nameValues.add(nameValue);
    }
}
