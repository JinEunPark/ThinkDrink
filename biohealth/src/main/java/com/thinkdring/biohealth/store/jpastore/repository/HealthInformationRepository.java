package com.thinkdring.biohealth.store.jpastore.repository;

import com.thinkdring.biohealth.aggregate.user.HealthInformation;
import com.thinkdring.biohealth.store.jpo.HealthInformationJpo;
import com.thinkdring.biohealth.store.jpo.ProfileJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthInformationRepository extends JpaRepository<HealthInformationJpo, String> {
    public List<HealthInformation> findAllByGender(Boolean gender);
    public List<HealthInformationJpo> findAllByName(String name);

}
