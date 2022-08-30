package com.thinkdring.biohealth.store;

import com.thinkdring.biohealth.aggregate.cafe.beverage.BeverageInformation;

import java.util.List;

public interface BeverageStore {

    public String create(BeverageInformation beverageInformation);
    public BeverageInformation retrieveByAutoCreatedId(String AutoCreatedId);
    public List<BeverageInformation> retrieveByMenu(String menu);
    public List<BeverageInformation> retrieveAll();
    public void update(BeverageInformation beverageInformation);
    public void delete(String beverageId);
    public boolean exists(String beverageId);

}
