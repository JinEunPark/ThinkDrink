package com.thinkdring.biohealth.service.sdo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class HealthInformationCdo {

    private String name;
    private double height;
    private double weight;
    private boolean gender;// ture == female
}
