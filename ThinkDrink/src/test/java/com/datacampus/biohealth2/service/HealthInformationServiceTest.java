package com.datacampus.biohealth2.service;

import com.datacampus.biohealth2.constant.Activity;
import com.datacampus.biohealth2.constant.Gender;
import com.datacampus.biohealth2.constant.Role;
import com.datacampus.biohealth2.entity.HealthInformation;
import com.datacampus.biohealth2.entity.Member;
import com.datacampus.biohealth2.repository.HealthInformationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
@TestPropertySource(locations="classpath:application-test.properties")
class HealthInformationServiceTest {
    @Autowired
    private HealthInformationRepository healthInformationRepository;
    @Autowired
    private HealthInformationService healthInformationService;
    public Member createMember(){
        Member member = new Member();
        member.setAddress("sdf");
        member.setName("asdf");
        member.setEmail("asdf@aef");
        member.setPassword("asefAsdasd");
        member.setRole(Role.USER);
        return member;

    }
    public HealthInformation createHealthInformation(){
        HealthInformation healthInformation = new HealthInformation();
        healthInformation.setMember(createMember());
        healthInformation.setAge(12);
        healthInformation.setGender(Gender.FEMALE);
        healthInformation.setHeight(180.0);
        healthInformation.setWeight(56);
        healthInformation.setActivityType(Activity.hyperactivity);
        return healthInformation;
    }
    @Test
    void saveHealthInformation() {
        HealthInformation healthInformation = createHealthInformation();
        HealthInformation healthInformationSaved = healthInformationService.saveHealthInformation(healthInformation);
        assertEquals(healthInformation.getActivityType(),healthInformationSaved.getActivityType());
        assertEquals(healthInformation.getAge(),healthInformationSaved.getAge());
        assertEquals(healthInformation.getGender(),healthInformationSaved.getGender());
        assertEquals(healthInformation.getHeight(),healthInformationSaved.getHeight());
        assertEquals(healthInformation.getWeight(),healthInformationSaved.getWeight());
        assertEquals(healthInformation.getId(),healthInformationSaved.getId());
        assertEquals(healthInformation.getMember(),healthInformationSaved.getMember());
        System.out.println(healthInformationSaved.toString()+"test!!");
    }
}