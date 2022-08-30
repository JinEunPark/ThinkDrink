package com.datacampus.biohealth2.dto;

import com.datacampus.biohealth2.constant.Activity;
import com.datacampus.biohealth2.constant.Gender;
import com.datacampus.biohealth2.entity.HealthInformation;
import com.datacampus.biohealth2.entity.Member;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class HealthInformationDto {

    private Long id;

    @NotNull
    @JoinColumn(name="member_id")
    private Member member;

    private double height;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private double weight;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Activity activityType;

    private static ModelMapper modelMapper = new ModelMapper();

    public HealthInformation createHealthInformation(){
        return modelMapper.map(this,HealthInformation.class);
    }

    public static HealthInformationDto of(HealthInformation healthInformation){
        return modelMapper.map(healthInformation, HealthInformationDto.class);
    }


}
