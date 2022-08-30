package com.datacampus.biohealth2.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "beverage_img")
@Getter
@Setter

public class BeverageImg extends BaseEntity {
    @Id
    @Column(name = "beverage_img_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String imgName;
    private String oriImgName;//원본 이미지 파일 명
    private String imgUrl;//이미지 조회 경로

    private String repimgYn;//음료 이미지 존재 여부

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "beverage_id")
    private BeverageInformation beverageInformation;

    public void updateBeverageInformationImg(String oriImgName, String imgName, String imgUrl) {
        this.oriImgName = oriImgName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }


}
