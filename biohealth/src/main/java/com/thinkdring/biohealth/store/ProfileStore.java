package com.thinkdring.biohealth.store;

import com.thinkdring.biohealth.aggregate.cafe.beverage.BeverageInformation;
import com.thinkdring.biohealth.aggregate.user.Profile;

import java.util.List;

public interface ProfileStore {
    public String create(Profile profile);
    public Profile retrieveByAutoCreatedId(String autoCreatedId);
    public List<Profile> retrieveByName(String userName);
    public List<Profile> retrieveByEmail(String email);

    public List<Profile> retrieveAll();
    public void update(Profile profile);
    public void delete(String userName);
    public boolean exists(String userName);
}
