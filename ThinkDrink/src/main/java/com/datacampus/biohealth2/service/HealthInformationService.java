package com.datacampus.biohealth2.service;

import com.datacampus.biohealth2.dto.HealthInformationDto;
import com.datacampus.biohealth2.entity.HealthInformation;
import com.datacampus.biohealth2.entity.Member;
import com.datacampus.biohealth2.repository.HealthInformationRepository;
import com.datacampus.biohealth2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class HealthInformationService {
    private final HealthInformationRepository healthInformationRepository;
    private final MemberRepository memberRepository;


    public HealthInformationDto getHealthInformationDto(Member member){
        System.out.println("error health service error");
        HealthInformation healthInformation = healthInformationRepository.findByMember_Id(member.getId());
        HealthInformationDto healthInformationDto = HealthInformationDto.of(healthInformation);
        return healthInformationDto;

    }
    public HealthInformation saveHealthInformation(HealthInformation healthInformation){

        return healthInformationRepository.save(healthInformation);
    }

}
