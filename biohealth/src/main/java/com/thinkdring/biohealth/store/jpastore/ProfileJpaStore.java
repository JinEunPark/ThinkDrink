package com.thinkdring.biohealth.store.jpastore;

import com.thinkdring.biohealth.exception.NoSuchProfileException;
import com.thinkdring.biohealth.aggregate.user.Profile;
import com.thinkdring.biohealth.store.ProfileStore;
import com.thinkdring.biohealth.store.jpastore.repository.ProfileRepository;
import com.thinkdring.biohealth.store.jpo.ProfileJpo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Getter
@Setter
@NoArgsConstructor
public class ProfileJpaStore implements ProfileStore {

    private ProfileRepository profileRepository;


    public ProfileJpaStore(ProfileRepository profileRepository) {

        this.profileRepository = profileRepository;
    }
    @Override
    public String create(Profile profile){
        profileRepository.save(new ProfileJpo(profile));

        return profile.getId();
    }

    @Override
    public Profile retrieveByAutoCreatedId(String autoCreatedId) {
        Optional<ProfileJpo> profileJpo = profileRepository.findById(autoCreatedId);
        if(!profileJpo.isPresent()){
            throw new NoSuchProfileException(String.format("profile(%s) is not found",autoCreatedId));

        }

        return profileJpo.get().profileJpoToProfile();
    }

    @Override
    public List<Profile> retrieveByName(String userName) {
        return null;
    }

    @Override
    public List<Profile> retrieveByEmail(String email) {
        return null;
    }
    @Override
    public List<Profile> retrieveAll(){
        List<ProfileJpo> profileJpos = profileRepository.findAll();
        return profileJpos.stream().map(ProfileJpo::profileJpoToProfile).collect(Collectors.toList());
    }

    @Override
    public void update(Profile profile) {
        profileRepository.save(new ProfileJpo(profile));

    }

    @Override
    public void delete(String profileId) {
        profileRepository.deleteById(profileId);

    }

    @Override
    public boolean exists(String profileId) {
        return profileRepository.existsById(profileId);
    }
}
