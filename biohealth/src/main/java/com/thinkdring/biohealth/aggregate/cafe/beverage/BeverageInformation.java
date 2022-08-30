package com.thinkdring.biohealth.aggregate.cafe.beverage;

import com.thinkdring.biohealth.aggregate.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BeverageInformation extends Entity {


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


    //Constructor1
    public BeverageInformation(String idFromAutoCreated, String bigCategory, String beverageMenu, double sugar, boolean ice, double kcal, double protein, double sodium, double saturatedFat, double caffeine,String cafeId) {
        super(idFromAutoCreated);
        this.BigCategory = bigCategory;
        this.beverageMenu = beverageMenu;
        this.Sugar = sugar;
        this.ice = ice;
        this.Kcal = kcal;
        this.Protein = protein;
        this.Sodium = sodium;
        this.saturatedFat = saturatedFat;
        this.Caffeine = caffeine;
        this.cafeId = cafeId;
    }

    //constructor2
    public BeverageInformation(String bigCategory, String beverageMenu, double sugar, boolean ice, double kcal, double protein, double sodium, double saturatedFat, double caffeine, String cafeId) {
        super();
        this.BigCategory = bigCategory;
        this.beverageMenu = beverageMenu;
        this.Sugar = sugar;
        this.ice = ice;
        this.Kcal = kcal;
        this.Protein = protein;
        this.Sodium = sodium;
        this.saturatedFat = saturatedFat;
        this.Caffeine = caffeine;
    }
}
