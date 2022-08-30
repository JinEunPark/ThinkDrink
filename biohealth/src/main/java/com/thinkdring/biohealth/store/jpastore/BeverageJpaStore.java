package com.thinkdring.biohealth.store.jpastore;

import com.thinkdring.biohealth.aggregate.cafe.beverage.BeverageInformation;
import com.thinkdring.biohealth.exception.NoSuchBeverageInformationException;
import com.thinkdring.biohealth.store.BeverageStore;
import com.thinkdring.biohealth.store.jpastore.repository.BeverageInformationRepository;
import com.thinkdring.biohealth.store.jpo.BeverageInformationJpo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BeverageJpaStore implements BeverageStore {

    private BeverageInformationRepository beverageInformationRepository;

    public BeverageJpaStore(BeverageInformationRepository beverageInformationRepository){
        this.beverageInformationRepository = beverageInformationRepository;

    }
    @Override
    public String create(BeverageInformation beverageInformation) {

        beverageInformationRepository.save(new BeverageInformationJpo(beverageInformation));
        return beverageInformation.getId();
    }

    @Override
    public BeverageInformation retrieveByAutoCreatedId(String AutoCreatedId) {

        Optional<BeverageInformationJpo> beverageInformationJpo = beverageInformationRepository.findById(AutoCreatedId);
        if(!beverageInformationJpo.isPresent()){
            throw new NoSuchBeverageInformationException(String.format("there is no such beverage information(%s)",AutoCreatedId));
        }

        return beverageInformationJpo.get().beverageInformationJpoToBeverageInformation();
    }

    @Override
    public List<BeverageInformation> retrieveByMenu(String menu) {
        List<BeverageInformationJpo> beverageInformationJpos = beverageInformationRepository.findAllByBeverageMenu(menu);
        return beverageInformationJpos.stream().map(BeverageInformationJpo::beverageInformationJpoToBeverageInformation)
                .collect(Collectors.toList());


    }

    @Override
    public List<BeverageInformation> retrieveAll() {
        List<BeverageInformationJpo> beverageInformationJpos = beverageInformationRepository.findAll();

        return beverageInformationJpos.stream().map(BeverageInformationJpo::beverageInformationJpoToBeverageInformation).collect(Collectors.toList());

    }

    @Override
    public void update(BeverageInformation beverageInformation) {
        beverageInformationRepository.save(new BeverageInformationJpo(beverageInformation));
    }

    @Override
    public void delete(String beverageId) {
        beverageInformationRepository.deleteById(beverageId);

    }

    @Override
    public boolean exists(String beverageId) {
       return beverageInformationRepository.existsById(beverageId);
    }
}
