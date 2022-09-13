package com.datacampus.biohealth2.repository;

import com.datacampus.biohealth2.entity.BeverageIntake;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeverageIntakeRepository extends JpaRepository<BeverageIntake,Long> {
    List<BeverageIntake> findAllByRegTimeAfterAndRegTimeBefore(String startTimeStamp, String endTimeStamp);

}
