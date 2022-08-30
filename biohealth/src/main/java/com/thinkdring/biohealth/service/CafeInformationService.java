package com.thinkdring.biohealth.service;

import com.thinkdring.biohealth.aggregate.cafe.CafeInformation;

import java.util.List;

public interface CafeInformationService {
    public String register(String name,String id);
    public CafeInformation findCafeById(String id);
    public List<CafeInformation> findCafeByCafeName(String cafeName);
    public void remove(CafeInformation cafeInformation);
    public void modifyCafeInformation(String cafeId,String cafeName);

}
