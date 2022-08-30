package com.thinkdring.biohealth.store.jpastore;

import com.thinkdring.biohealth.aggregate.cafe.CafeInformation;
import com.thinkdring.biohealth.exception.NoSuchCafeInformationException;
import com.thinkdring.biohealth.store.CafeInformationStore;
import com.thinkdring.biohealth.store.jpastore.repository.CafeInformationRepository;
import com.thinkdring.biohealth.store.jpo.CafeInformationJpo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CafeInformationJpaStore implements CafeInformationStore {
    private CafeInformationRepository cafeInformationRepository;

    public CafeInformationJpaStore(CafeInformationRepository cafeInformationRepository){
        this.cafeInformationRepository = cafeInformationRepository;
    }

    @Override
    public String create(CafeInformation cafeInformation) {

        cafeInformationRepository.save(new CafeInformationJpo(cafeInformation));
        return cafeInformation.getId();
    }

    @Override
    public CafeInformation retrieveByAutoCreatedId(String autoCreatedId) {
        Optional<CafeInformationJpo> cafeInformationJpo = cafeInformationRepository.findById(autoCreatedId);
        if(!cafeInformationJpo.isPresent()){
            throw new NoSuchCafeInformationException(String.format("there is no %s cafeInformation please check the id of cafe"));
        }
        return cafeInformationJpo.get().cafeInformationJpoToCafeInformation();
    }

    @Override
    public List<CafeInformation> retrieveByName(String cafeName) {
        List<CafeInformationJpo> cafeInformationJpos  = cafeInformationRepository.findAllByCafeName(cafeName);
        return cafeInformationJpos.stream().map(CafeInformationJpo::cafeInformationJpoToCafeInformation).collect(Collectors.toList());
    }

    @Override
    public void update(CafeInformation cafeInformation) {
        cafeInformationRepository.save(new CafeInformationJpo(cafeInformation));

    }

    @Override
    public void delete(String cafeId) {
        cafeInformationRepository.deleteById(cafeId);

    }

    @Override
    public boolean exists(String cafeId) {
        return cafeInformationRepository.existsById(cafeId);
    }

    @Override
    public List<CafeInformation> retrieveAll() {
        List<CafeInformationJpo> cafeInformationJpos = cafeInformationRepository.findAll();
        return cafeInformationJpos.stream().map(CafeInformationJpo::cafeInformationJpoToCafeInformation).collect(Collectors.toList());
    }
}
