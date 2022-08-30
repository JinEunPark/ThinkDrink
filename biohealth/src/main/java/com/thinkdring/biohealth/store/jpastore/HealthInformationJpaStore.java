package com.thinkdring.biohealth.store.jpastore;

import com.thinkdring.biohealth.aggregate.cafe.beverage.BeverageInformation;
import com.thinkdring.biohealth.aggregate.user.HealthInformation;
import com.thinkdring.biohealth.store.HealthInformationStore;
import com.thinkdring.biohealth.store.jpastore.repository.HealthInformationRepository;
import com.thinkdring.biohealth.store.jpo.HealthInformationJpo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class HealthInformationJpaStore implements HealthInformationStore {
    private HealthInformationRepository healthInformationRepository;

    public HealthInformationJpaStore(HealthInformationRepository healthInformationRepository){//객체를 주입받는 방식으로 설정

        this.healthInformationRepository = healthInformationRepository;

    }

    @Override
    public String create(HealthInformation healthInformation) {
        healthInformationRepository.save(new HealthInformationJpo(healthInformation));
        return healthInformation.getId();
    }

    @Override
    public BeverageInformation retrieveByAutoCreatedId(String AutoCreatedId) {
        return null;
    }

    @Override
    public List<HealthInformation> retrieveByName(String name) {
        List<HealthInformationJpo> healthInformationJpos = healthInformationRepository.findAllByName(name);

        return healthInformationJpos.stream().map(HealthInformationJpo::healthInformationJpoToHealthInformation)
                .collect(Collectors.toList());
    }
    @Override
    public List<HealthInformation> retrieveAll(){
        List<HealthInformationJpo> healthInformationJpos = healthInformationRepository.findAll();
        return healthInformationJpos.stream().map(HealthInformationJpo::healthInformationJpoToHealthInformation)
                .collect(Collectors.toList());
    }

    @Override
    public void update(HealthInformation healthInformation) {
        healthInformationRepository.save(new HealthInformationJpo(healthInformation));

    }

    @Override
    public void delete(String healthInformationId) {
        healthInformationRepository.deleteById(healthInformationId);

    }

    @Override
    public boolean exists(String healthInformaitonId) {

        return healthInformationRepository.existsById(healthInformaitonId);

    }
}
