package com.datacampus.biohealth2.dto;

import com.datacampus.biohealth2.constant.IceOrHot;
import com.datacampus.biohealth2.entity.BeverageInformation;
import com.datacampus.biohealth2.entity.CafeInformation;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BeverageFormDto {

    private Long id;

    @NotBlank(message="you should input beverage information")
    private String BeverageName;

    private String bigCategory;

    @Enumerated(EnumType.STRING)
    private IceOrHot iceOrHot;

    private double kcal;

    private double sugar;

    private double protein;

    private double sodium;

    private double saturatedFat;

    private double caffeine;

    @NotBlank(message="you should input beverage information")
    private CafeInformation cafeName;

    private static ModelMapper modelMapper = new ModelMapper();

    private List<BeverageImgDto> beverageImgDtoList = new ArrayList<>();//음료정보 수정후 저장할 리스트

    private List<Long> beverageImgIds = new ArrayList<>();

    public BeverageInformation createBeverageInformation(){

        return modelMapper.map(this, BeverageInformation.class);

    }

    public static BeverageInformationDto of(BeverageInformation beverageInformation){
        return modelMapper.map(beverageInformation,BeverageInformationDto.class);
    }

}
