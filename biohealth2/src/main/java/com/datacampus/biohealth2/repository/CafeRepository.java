package com.datacampus.biohealth2.repository;

import com.datacampus.biohealth2.entity.CafeInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CafeRepository extends JpaRepository<CafeInformation,Long> {
    public List<CafeInformation> findAllByCafeName(String cafeName);
}
