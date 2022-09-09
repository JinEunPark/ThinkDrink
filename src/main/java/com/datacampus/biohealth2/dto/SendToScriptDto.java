package com.datacampus.biohealth2.dto;

import com.datacampus.biohealth2.entity.PerDayNutrition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SendToScriptDto {

    private Long id;

    private double kcal;

    private double sugar;

    private double protein;

    private double sodium;

    private double saturatedFat;

    private double caffeine;

    private double drink_kcal;

    private double drink_sugar;

    private double drink_protein;

    private double drink_Sodium;

    private double drink_saturatedFat;

    private double drink_caffeine;

    public SendToScriptDto(PerDayNutrition perDayNutrition) {


    }


    public SendToScriptDto(PerDayNutritionDto perDayNutritionDto) {
        this.id = perDayNutritionDto.getId();
        this.kcal = perDayNutritionDto.getKcal();
        this.sugar = perDayNutritionDto.getSugar();
        this.protein = perDayNutritionDto.getProtein();
        this.sodium = perDayNutritionDto.getSodium();
        this.saturatedFat = perDayNutritionDto.getSaturatedFat();
        this.caffeine = perDayNutritionDto.getCaffeine();
        this.drink_kcal = perDayNutritionDto.getDrink_kcal();
        this.drink_sugar = perDayNutritionDto.getDrink_sugar();
        this.drink_protein = perDayNutritionDto.getDrink_protein();
        this.drink_Sodium = perDayNutritionDto.getDrink_Sodium();
        this.drink_saturatedFat = perDayNutritionDto.getDrink_saturatedFat();
        this.drink_caffeine = perDayNutritionDto.getDrink_caffeine();
    }
}
