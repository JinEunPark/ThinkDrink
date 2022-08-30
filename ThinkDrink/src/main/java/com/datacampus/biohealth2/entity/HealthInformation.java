package com.datacampus.biohealth2.entity;

import com.datacampus.biohealth2.constant.Activity;
import com.datacampus.biohealth2.constant.Gender;
import com.datacampus.biohealth2.dto.HealthInformationDto;
import com.datacampus.biohealth2.dto.HealthInformationFormDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter@NoArgsConstructor
@Entity
@Table(name="health_Information")
public class HealthInformation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)//field를 항상 같게 설정한다.
    @JoinColumn(name="member_id")
    private Member member;
    private double height;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer age;

    private double weight;

    @Enumerated(EnumType.STRING)
    private Activity activityType;

    public void updateHealthInformation(double height, double weight, Integer age,Gender
            gender, Activity activityType){
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.gender = gender;
        this.activityType = activityType;
    }

    public static HealthInformation createHealthInformation(HealthInformationFormDto healthInformationFormDto){

        HealthInformation healthInformation = new HealthInformation();
        healthInformation.setAge(healthInformationFormDto.getAge());
        healthInformation.setGender(healthInformationFormDto.getGender());
        healthInformation.setActivityType(healthInformationFormDto.getActivityType());
        healthInformation.setHeight(healthInformationFormDto.getHeight());
        healthInformation.setWeight(healthInformationFormDto.getWeight());
        healthInformation.setMember(healthInformationFormDto.getMember());

        return healthInformation;
    }

}
