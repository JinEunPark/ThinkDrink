package com.thinkdring.biohealth.service;

import com.thinkdring.biohealth.aggregate.user.Profile;
import com.thinkdring.biohealth.shared.NameValueList;
import com.thinkdring.biohealth.store.jpo.ProfileJpo;

import java.util.List;

public interface ProfileService {
    public String register(ProfileJpo profileJpo);
    public Profile findProfileById(String autoCreatedId);
    public List<Profile> findProfilesByName(String userName);
    public void modify(String name, NameValueList nameValueList);
    public void delete(String name);
}
