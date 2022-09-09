package com.datacampus.biohealth2.repository;

import com.datacampus.biohealth2.entity.HealthInformation;
import com.datacampus.biohealth2.entity.Member;
import com.datacampus.biohealth2.entity.PerDayNutrition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PerDayNutritionRepository extends JpaRepository<PerDayNutrition, Long> {

//    Optional<PerDayNutrition> findPerDayNutritionByMember();
    PerDayNutrition findPerDayNutritionByHealthInformation_Id(Long healthInformation_id);
}
