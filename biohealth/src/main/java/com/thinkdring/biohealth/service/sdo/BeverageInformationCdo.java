package com.thinkdring.biohealth.service.sdo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BeverageInformationCdo implements Serializable {
    private String BigCategory;
    private String beverageMenu;
    private double Sugar;
    private boolean ice;
    private double Kcal;
    private double Protein;
    private double Sodium;
    private double saturatedFat;
    private double Caffeine;
}
