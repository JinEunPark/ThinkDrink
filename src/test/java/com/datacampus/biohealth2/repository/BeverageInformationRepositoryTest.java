package com.datacampus.biohealth2.repository;

import com.datacampus.biohealth2.constant.IceOrHot;
import com.datacampus.biohealth2.entity.BeverageInformation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

import static org.aspectj.runtime.internal.Conversions.longValue;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
class BeverageInformationRepositoryTest {
    @Autowired
    BeverageInformationRepository beverageInformationRepository;

    public void createBeverageInformationList(){
        for(int i = 0; i<10; i++){
            BeverageInformation beverageInformation = new BeverageInformation();
            beverageInformation.setBeverageName("beverage"+i);
            beverageInformation.setBigCategory("category"+i);
            beverageInformation.setIceOrHot(IceOrHot.HOT);
            beverageInformation.setCaffeine(i*1);
            beverageInformation.setProtein(i*2);
            beverageInformation.setKcal(i*3);
            beverageInformation.setSodium(i*4);
            BeverageInformation beverageInformationSaved = beverageInformationRepository.save(beverageInformation);

        }

    }
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private Long beverageId;
//    @Column(nullable = false)
//    private String bigCategory;
//    @Column(nullable = true)
//
//    private boolean ice;
//    @Column(nullable = true)
//
//    private String beverageName;
//    @Column(nullable = false)
//
//    private double kcal;
//
//    @Column(nullable = false)
//
//    private String cafeName;
//    @Column(nullable = false)
//
//    private Long cafeId;
    @Test
    public void findByAllCaffeineLessThanTest(){
        this.createBeverageInformationList();
        List<BeverageInformation> beverageList = beverageInformationRepository.findByCaffeineLessThan(3.0);
        for(BeverageInformation beverageInformation: beverageList){
            System.out.println(beverageInformation.toString());
        }
    }

}