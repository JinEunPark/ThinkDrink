package com.datacampus.biohealth2.repository;

import com.datacampus.biohealth2.entity.BeverageInformation;
import com.datacampus.biohealth2.entity.CafeInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeverageInformationRepository extends JpaRepository<BeverageInformation, Long> {
    public List<BeverageInformation> findByBeverageName(String beverageName);
    public List<BeverageInformation> findByCaffeineLessThan(Double caffeine);

    public List<BeverageInformation> findAllByCafeId(CafeInformation cafeId);
}
