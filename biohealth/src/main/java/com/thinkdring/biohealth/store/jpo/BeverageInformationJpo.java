package com.thinkdring.biohealth.store.jpo;

import com.thinkdring.biohealth.aggregate.cafe.beverage.BeverageInformation;
import lombok.*;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
@Getter
@Setter
@Entity
@NoArgsConstructor(force = true)
@Table(name="BEVERAGE_INFORMATION")
@ToString
public class BeverageInformationJpo {
//    @ManyToOne
//    @JoinColumn(name="cafeId", referencedColumnName = "cafeId")

    @Id
    @Column(name="beverage_id")
    private String idFromAutoCreated;
    @Column(name="cafe_name",nullable=false)

    private String bigCategory;

    @Column(name="beverage_Menu",nullable=true)

    private String beverageMenu;
    @Column(name="sugar",nullable=true)

    private double sugar;
    @Column(name="ice",nullable=true)

    private boolean ice;
    @Column(name="kcal",nullable=true)

    private double kcal;
    @Column(name="protein",nullable=true)

    private double protein;
    @Column(name="sodium",nullable=true)

    private double sodium;
    @Column(name="saturatedFat",nullable=true)

    private double saturatedFat;
    @Column(name="caffeine",nullable=true)

    private double caffeine;
    @Column(name="cafe_id", nullable=true)//수정함 확인할 것
    private String cafeId;


    public BeverageInformationJpo(BeverageInformation beverageInformation){
        BeanUtils.copyProperties(beverageInformation,this);
    }
    public BeverageInformation beverageInformationJpoToBeverageInformation(){// transfer jpo object to beverageinformatino object
        BeverageInformation beverageInformation = new BeverageInformation(
                this.idFromAutoCreated,
                this.bigCategory,
                this.beverageMenu,
                this.sugar,
                this.ice,
                this.kcal,
                this.protein,
                this.sodium,
                this.saturatedFat,
                this.caffeine,
                this.cafeId
        );


        return beverageInformation;
    }


}
