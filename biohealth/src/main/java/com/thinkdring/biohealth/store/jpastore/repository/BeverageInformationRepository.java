package com.thinkdring.biohealth.store.jpastore.repository;

import com.thinkdring.biohealth.aggregate.cafe.beverage.BeverageInformation;
import com.thinkdring.biohealth.store.jpo.BeverageInformationJpo;
import com.thinkdring.biohealth.store.jpo.ProfileJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeverageInformationRepository extends JpaRepository<BeverageInformationJpo, String> {
    public List<BeverageInformationJpo> findAllByBeverageMenu(String menu);
    public List<BeverageInformationJpo> findAllByBigCategory(String bigCategory);

}
