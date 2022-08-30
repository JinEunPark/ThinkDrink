package com.thinkdring.biohealth.store.jpo;

import com.thinkdring.biohealth.aggregate.cafe.CafeInformation;
import lombok.*;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="CAFE_INFROMATION")
@ToString

public class CafeInformationJpo {

    @Id
    @Column(name="cafe_id", nullable=false)
    private String idFromAutoCreated;
    @Column(name="cafe_name",nullable=false)
    private String cafeName;


    public CafeInformationJpo(CafeInformation cafeInformation){ //transfer cafeInformation to cafeinformationjpo Object
        BeanUtils.copyProperties(cafeInformation,this);

    }

    public CafeInformation cafeInformationJpoToCafeInformation(){
        CafeInformation cafeInformation = new CafeInformation(
                this.cafeName,
                this.idFromAutoCreated
        );
        return cafeInformation;
    }
}
