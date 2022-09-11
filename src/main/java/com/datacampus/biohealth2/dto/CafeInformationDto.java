package com.datacampus.biohealth2.dto;

import com.datacampus.biohealth2.entity.CafeInformation;
import com.datacampus.biohealth2.entity.HealthInformation;
import org.modelmapper.ModelMapper;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CafeInformationDto {
    private String cafeName;

    private Long cafeId;

    public static ModelMapper modelMapper = new ModelMapper();
    public CafeInformation createCafeInformation(){
        return modelMapper.map(this,CafeInformation.class);
    }

    public static CafeInformationDto of(CafeInformation cafeInformation){
        return modelMapper.map(cafeInformation, CafeInformationDto.class);
    }
}
