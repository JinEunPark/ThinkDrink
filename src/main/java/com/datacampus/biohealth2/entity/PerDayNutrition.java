package com.datacampus.biohealth2.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter@NoArgsConstructor
@Entity
@Table(name="PerDay_Nutrition")
public class PerDayNutrition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PerDay_Nutrition_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)//field를 항상 같게 설정한다.
    @JoinColumn(name="health_Information_id")
    private HealthInformation healthInformation;

    @Column(nullable = true)
    private double kcal;

    @Column(nullable = true)
    private double sugar;

    @Column(nullable = true)
    private double protein;

    @Column(nullable = true)
    private double sodium;

    @Column(nullable = true)
    private double saturatedFat;

    @Column(nullable = true)
    private double caffeine;


}
