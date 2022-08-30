package com.datacampus.biohealth2.repository;

import com.datacampus.biohealth2.dto.HealthInformationDto;
import com.datacampus.biohealth2.entity.HealthInformation;
import com.datacampus.biohealth2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HealthInformationRepository extends JpaRepository<HealthInformation, Member> {

     public Optional<HealthInformation> findById(Long member_id);
     HealthInformation findByMember_Id(Long member_id);



}
