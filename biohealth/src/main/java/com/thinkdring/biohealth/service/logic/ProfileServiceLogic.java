package com.thinkdring.biohealth.service.logic;

import com.thinkdring.biohealth.aggregate.user.Profile;
import com.thinkdring.biohealth.service.ProfileService;
import com.thinkdring.biohealth.store.jpo.ProfileJpo;
import com.thinkdring.biohealth.shared.NameValueList;
import com.thinkdring.biohealth.store.ProfileStore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Getter
@Setter
@NoArgsConstructor

public class ProfileServiceLogic implements ProfileService {
    private ProfileStore profileStore;

    public ProfileServiceLogic(ProfileStore profileStore){//profileStore 객체를 생성해서 Spring ioc가 생썽해서 객체를주입함
        this.profileStore = profileStore;

    }

    @Override
    public String register(ProfileJpo profileJpo){
//        profileStore.create();
        return null;
    }

    @Override
    public Profile findProfileById(String autoCreatedId) {
        return null;
    }

    @Override
    public List<Profile> findProfilesByName(String userName) {
        return null;
    }

    @Override
    public void modify(String name, NameValueList nameValueList) {

    }

    @Override
    public void delete(String name) {

    }
}
