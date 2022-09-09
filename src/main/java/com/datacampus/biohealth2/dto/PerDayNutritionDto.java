package com.datacampus.biohealth2.dto;

import com.datacampus.biohealth2.entity.HealthInformation;
import com.datacampus.biohealth2.entity.Member;
import com.datacampus.biohealth2.entity.PerDayNutrition;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@JsonSerialize
@JsonIgnoreProperties("healthInformation")
public class PerDayNutritionDto implements Serializable {


    private Long id;

    private Member member;

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

    private HealthInformation healthInformation;


    private static ModelMapper modelMapper = new ModelMapper();//변수 명과 값을 비교해서 객체를 복사해주는 객체

    public PerDayNutrition createPerDayNutrition(){//PerDayNutritionDto -> PerDayNutrition entity
        return modelMapper.map(this, PerDayNutrition.class);
    }

    public static PerDayNutritionDto of(PerDayNutrition perDayNutrition){//PerDayNutrition-> PerDayNutritionDto 반환
        return modelMapper.map(perDayNutrition, PerDayNutritionDto.class);
    }
//    @Override
//    public String toString(){
//        return "ㅜㅕㅣㅣ";
//
//    }

}
