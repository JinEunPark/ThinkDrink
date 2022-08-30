package com.thinkdring.biohealth.store.jpastore.repository;

import com.thinkdring.biohealth.aggregate.cafe.CafeInformation;
import com.thinkdring.biohealth.store.jpo.CafeInformationJpo;
import com.thinkdring.biohealth.store.jpo.ProfileJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CafeInformationRepository extends JpaRepository<CafeInformationJpo, String> {
    public List<CafeInformationJpo> findAllByCafeName(String cafeName);
}
