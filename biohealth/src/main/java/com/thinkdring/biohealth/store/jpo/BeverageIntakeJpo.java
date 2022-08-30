package com.thinkdring.biohealth.store.jpo;

import com.thinkdring.biohealth.aggregate.user.BeverageIntake;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor(force = true)
@Table(name = "BEVERAGE_INTAKEe")
@ToString
public class BeverageIntakeJpo {

    @Id
    @Column(name = "", nullable = false)
    private String personId;

    public BeverageIntakeJpo(String personId, String id, String bigCategory, String beverageMenu, double sugar, boolean ice, double kcal, double protein, double sodium, double saturatedFat, double caffeine, String cafeId, long intakeTime) {
        this.personId = personId;
        this.id = id;
        BigCategory = bigCategory;
        this.beverageMenu = beverageMenu;
        Sugar = sugar;
        this.ice = ice;
        Kcal = kcal;
        Protein = protein;
        Sodium = sodium;
        this.saturatedFat = saturatedFat;
        Caffeine = caffeine;
        this.cafeId = cafeId;
        IntakeTime = intakeTime;
    }

    public BeverageIntakeJpo(BeverageIntake beverageIntake) {
        BeanUtils.copyProperties(beverageIntake,this);
    }

    public BeverageIntake BeverageIntakeJpoToBeverageIntake(BeverageIntakeJpo beverageIntakeJpo){
        BeverageIntake beverageIntake = new BeverageIntake(
        beverageIntakeJpo.getPersonId(),
        beverageIntakeJpo.getId(),
        beverageIntakeJpo.getBigCategory(),
        beverageIntakeJpo.getBeverageMenu(),
        beverageIntakeJpo.getSugar(),
        beverageIntakeJpo.isIce(),
        beverageIntakeJpo.getKcal(),
        beverageIntakeJpo.getProtein(),
        beverageIntakeJpo.getSodium(),
        beverageIntakeJpo.getSaturatedFat(),
        beverageIntakeJpo.getCaffeine(),
        beverageIntakeJpo.getCaffeine(),
        beverageIntakeJpo.getCafeId(),
        beverageIntakeJpo.getIntakeTime());

        return beverageIntake;
    }
    @Column(name = "ID", nullable = false)
    private String id;

    @Column(name = "BIG_CATEGORY", nullable = false)
    private String BigCategory;

    @Column(name = "BEVERAGE_MENU", nullable = false)
    private String beverageMenu;

    @Column(name = "SUGAR", nullable = false)
    private double Sugar;

    @Column(name = "ICE", nullable = false)
    private boolean ice;

    @Column(name = "KCAL", nullable = false)
    private double Kcal;

    @Column(name = "PROTEIN", nullable = false)
    private double Protein;

    @Column(name = "SODIUM", nullable = false)
    private double Sodium;

    @Column(name = "SATURATEDFAT", nullable = false)
    private double saturatedFat;

    @Column(name = "CAFFEINE", nullable = false)
    private double Caffeine;

    @Column(name = "CAFE_ID", nullable = false)
    private String cafeId;

    @Column(name = "INTAKETIME", nullable = false)
    private long IntakeTime;
}
