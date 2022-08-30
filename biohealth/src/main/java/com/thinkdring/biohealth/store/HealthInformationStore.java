package com.thinkdring.biohealth.store;

import com.thinkdring.biohealth.aggregate.cafe.beverage.BeverageInformation;
import com.thinkdring.biohealth.aggregate.user.HealthInformation;

import java.util.List;

public interface HealthInformationStore {
    public String create(HealthInformation healthInformation);
    public BeverageInformation retrieveByAutoCreatedId(String AutoCreatedId);
    public List<HealthInformation> retrieveByName(String name);

    List<HealthInformation> retrieveAll();

    public void update(HealthInformation healthInformation);
    public void delete(String name);
    public boolean exists(String name);
}
