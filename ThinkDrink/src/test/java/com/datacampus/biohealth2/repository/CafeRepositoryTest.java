package com.datacampus.biohealth2.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.datacampus.biohealth2.entity.CafeInformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;


@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")

class CafeRepositoryTest {
    @Autowired
    CafeRepository cafeRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("카페정보입력 테스트")
    public void createInformationTest(){

        CafeInformation cafeInformation = new CafeInformation();
        cafeInformation.setCafeName("starbucks");
        CafeInformation savedCaeInformation = cafeRepository.save(cafeInformation);
        System.out.println(savedCaeInformation.toString());

    }


}