package com.datacampus.biohealth2.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Getter @Setter
@NoArgsConstructor

public class BeverageIntake extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long intakeId;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member memberId;

    @ManyToOne
    @JoinColumn(name="beverage_id")
    private BeverageInformation beverageId;

//    private LocalDateTime intakeTime;
    //baseEntity extends 를 사용해서 이를 반환할 수 있게 만들었음 그래서 사용할 필ㅇ요가 없습니다.


}
