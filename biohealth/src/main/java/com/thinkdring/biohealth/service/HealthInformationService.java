package com.thinkdring.biohealth.service;

import com.thinkdring.biohealth.aggregate.user.HealthInformation;
import com.thinkdring.biohealth.shared.NameValueList;

import java.util.List;

public interface HealthInformationService {

    public String register(HealthInformation healthInformation);

    public String findHealthInformationById(String id);

    public List<HealthInformation> findHealthInformationByName(String name);

    public void modifyHealthInformation(String name, NameValueList nameValueList);

    public void remove(String name);

}
































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































