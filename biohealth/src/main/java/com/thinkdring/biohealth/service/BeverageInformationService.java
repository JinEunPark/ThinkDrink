package com.thinkdring.biohealth.service;

import com.thinkdring.biohealth.aggregate.cafe.beverage.BeverageInformation;
import com.thinkdring.biohealth.shared.NameValueList;
import com.thinkdring.biohealth.store.jpo.BeverageInformationJpo;

import java.util.List;

public interface BeverageInformationService {
    public String registerBeverageInformation(BeverageInformationJpo beverageInformationJpo);
    public BeverageInformation findBeverageInformationById(String Id);
    public List<BeverageInformation> findBeverageInformationByName(String beverageName);
    public void modifyBeverageInformation(String name, NameValueList nameValueList);
    public void removeBeverageInformation(String id);

}
