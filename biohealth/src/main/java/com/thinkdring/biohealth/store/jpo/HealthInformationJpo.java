package com.thinkdring.biohealth.store.jpo;

import com.thinkdring.biohealth.aggregate.user.HealthInformation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="HEALTH_INFORMATION")
@ToString
public class HealthInformationJpo {
    @Id
    @Column(name="health_id")
    private String idFromAutoCreated;
    private String name;
    private double height;
    private double weight;
    private boolean gender;// ture == female
    private Date foundationTime;//make == date of make this profile
    private String personId;//수정함 확인할 것

    public HealthInformationJpo(HealthInformation healthInformation) {

        this.name = healthInformation.getName();
        this.foundationTime = healthInformation.getFoundationTime();
        this.gender = healthInformation.isGender();
        this.height = healthInformation.getHeight();
        this.weight = healthInformation.getWeight();

    }

    public HealthInformation healthInformationJpoToHealthInformation(){
        HealthInformation healthInformation = new HealthInformation(
                this.name,
                this.height,
                this.weight,
                this.gender,
                this.personId
        );
        return healthInformation;
    }
}
