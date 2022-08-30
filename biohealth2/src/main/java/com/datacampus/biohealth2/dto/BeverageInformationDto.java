package com.datacampus.biohealth2.dto;

import com.datacampus.biohealth2.constant.IceOrHot;
import com.datacampus.biohealth2.entity.CafeInformation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter @Setter
public class BeverageInformationDto {

    private Long beverageId;

    private String bigCategory;

    @Enumerated(EnumType.STRING)
    private IceOrHot iceOrHot;

    private String beverageName;

    private double kcal;

    private double sugar;

    private double protein;

    private double sodium;

    private double saturatedFat;

    private double caffeine;

    private CafeInformation cafeName;

    private CafeInformation cafeId;
}
