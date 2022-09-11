package com.datacampus.biohealth2.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter@Setter
@Entity
@ToString
@Table(name="cafe_information")


public class CafeInformation {

    @Column(name="cafe_name")
    private String cafeName;

    @Id
    @Column(name="cafe_id", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cafeId;

    @JsonManagedReference
    @OneToMany(mappedBy = "cafeId")
    private List<BeverageInformation> beverageInformationList = new ArrayList<>();

}
