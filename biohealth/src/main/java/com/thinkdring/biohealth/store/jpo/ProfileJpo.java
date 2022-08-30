package com.thinkdring.biohealth.store.jpo;

import com.sun.istack.NotNull;
import com.thinkdring.biohealth.aggregate.user.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

//사람의 건강정보를 담음
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "PROFILE")
@ToString

public class ProfileJpo {

    @Id
    @Column(name="profile_id")
    private String idFromAutoCreated;
    @Column(name="user_id",nullable=false)
    private String userId;
    @Column(name="password",nullable=false)
    private String password;
    @Column(name="userName",nullable=false)

    private String userName;
    @Column(name="email",nullable=false)

    private String email;
    @Column(name="foundation_time",nullable=false)

    private Date foundation_Time;

    public ProfileJpo(Profile profile) {
        BeanUtils.copyProperties(profile, this);
    }


    //String idFromAutocreated, String userId, String password, String email, Date foundation_Time, String userName
    public Profile profileJpoToProfile() {
        Profile profile = new Profile(
                this.idFromAutoCreated,
                this.userId,
                this.password,
                this.email,
                this.foundation_Time,
                this.userName
        );
        return profile;
    }

}
