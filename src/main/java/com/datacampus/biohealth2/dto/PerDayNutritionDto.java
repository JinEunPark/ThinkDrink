package com.datacampus.biohealth2.dto;

import com.datacampus.biohealth2.entity.HealthInformation;
import com.datacampus.biohealth2.entity.Member;
import com.datacampus.biohealth2.entity.PerDayNutrition;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

public class PerDayNutritionDto {


    private Long id;

    private Member member;

    private double kcal;

    private double sugar;

    private double protein;

    private double sodium;

    private double saturatedFat;

    private double caffeine;


    private static ModelMapper modelMapper = new ModelMapper();//변수 명과 값을 비교해서 객체를 복사해주는 객체

    public PerDayNutrition createPerDayNutrition(){//PerDayNutritionDto -> PerDayNutrition entity
        return modelMapper.map(this, PerDayNutrition.class);
    }

    public PerDayNutritionDto of(PerDayNutrition perDayNutrition){//PerDayNutrition-> PerDayNutritionDto 반환
        return modelMapper.map(perDayNutrition, PerDayNutritionDto.class);
    }

}
