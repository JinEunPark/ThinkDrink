package com.thinkdring.biohealth.store;

import com.thinkdring.biohealth.aggregate.cafe.CafeInformation;
import com.thinkdring.biohealth.aggregate.cafe.beverage.BeverageInformation;

import java.util.List;

public interface CafeInformationStore {
    public String create(CafeInformation cafeInformation);
    public CafeInformation retrieveByAutoCreatedId(String AutoCreatedId);
    public List<CafeInformation> retrieveByName(String cafeName);
    public void update(CafeInformation cafeInformation);
    public void delete(String cafeName);
    public boolean exists(String cafeName);
    public List<CafeInformation> retrieveAll();
}
