package com.thinkdring.biohealth.aggregate.user;

import com.thinkdring.biohealth.aggregate.cafe.beverage.BeverageInformation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor

public class BeverageIntake {
    
    private String personId;
    private String id;
    private String BigCategory;
    private String beverageMenu;
    private double Sugar;
    private boolean ice;
    private double Kcal;
    private double Protein;
    private double Sodium;
    private double saturatedFat;
    private double Caffeine;
    private String cafeId;
    private long IntakeTime;
    
    public BeverageIntake( BeverageInformation beverageInformation, Profile profile){
        this.BigCategory = beverageInformation.getBigCategory();
        this.beverageMenu = beverageInformation.getBigCategory();
        this.Sugar = beverageInformation.getSugar();
        this.ice = beverageInformation.isIce();
        this.Kcal = beverageInformation.getKcal();
        this.Protein = beverageInformation.getProtein();
        this.Sodium = beverageInformation.getSodium();
        this.saturatedFat = beverageInformation.getSaturatedFat();
        this.Caffeine = beverageInformation.getCaffeine();
        this.cafeId = beverageInformation.getCafeId();
        this.personId = profile.getId();
        this.IntakeTime = System.currentTimeMillis();
    }


    public BeverageIntake(String personId, String id, String bigCategory, String beverageMenu, double sugar, boolean ice, double kcal, double protein, double sodium, double saturatedFat, double caffeine, double caffeine1, String cafeId, long intakeTime) {

    }
}
