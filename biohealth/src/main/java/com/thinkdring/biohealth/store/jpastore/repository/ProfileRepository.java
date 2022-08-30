package com.thinkdring.biohealth.store.jpastore.repository;

import com.thinkdring.biohealth.aggregate.user.Profile;
import com.thinkdring.biohealth.store.jpo.ProfileJpo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProfileRepository extends JpaRepository<ProfileJpo, String> {
   public List<Profile> findAllByUserName(String userName);
   public List<Profile> findAllByEmail(String email);

}
