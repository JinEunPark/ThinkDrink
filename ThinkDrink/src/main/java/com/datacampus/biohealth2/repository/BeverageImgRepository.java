package com.datacampus.biohealth2.repository;

import com.datacampus.biohealth2.entity.BeverageImg;
import com.datacampus.biohealth2.entity.BeverageInformation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeverageImgRepository extends JpaRepository<BeverageImg, Long> {
    List<BeverageImg> findByBeverageInformation_BeverageIdOrderByIdAsc(Long beverageId);

}
