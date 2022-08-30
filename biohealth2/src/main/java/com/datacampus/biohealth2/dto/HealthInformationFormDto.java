package com.datacampus.biohealth2.dto;

import com.datacampus.biohealth2.constant.Activity;
import com.datacampus.biohealth2.constant.Gender;
import com.datacampus.biohealth2.entity.HealthInformation;
import com.datacampus.biohealth2.entity.Member;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Getter
@Setter
public class HealthInformationFormDto {

    private Long id;

    @NotNull
    @JoinColumn(name="member_id")
    private Member member;

    @NotNull(message = "키는 필수 입력정보 입니다")
    private double height;

    @NotNull(message = "성별은 필수 입력사항입니다")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message = "몸무게는 필수 입력사항입니다")
    private double weight;

    @NotNull(message = "나이는 필수 입력사항입니다")
    private Integer age;

    @NotNull(message="활동성은 필수 입력사항입니다")
    @Enumerated(EnumType.STRING)
    private Activity activityType;

    private static ModelMapper modelMapper = new ModelMapper();

    public HealthInformation createHealthInformation(){
        return modelMapper.map(this,HealthInformation.class);
    }

    public HealthInformationFormDto of(HealthInformation healthInformation){
        return modelMapper.map(healthInformation, HealthInformationFormDto.class);
    }


}
