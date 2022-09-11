package com.datacampus.biohealth2.entity;

import com.datacampus.biohealth2.constant.IceOrHot;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class BeverageInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//dbms에서 값을 sql데이터를 받기위해서 auto increament를 dbms에 위임함
    @Column(name="beverage_id")
    private Long beverageId;

    @Column(nullable = true)
    private String bigCategory;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private IceOrHot iceOrHot;

    @Column(nullable = false)

    private String beverageName;
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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="cafe_id")
    private CafeInformation cafeId;

}
