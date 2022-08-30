package com.datacampus.biohealth2.dto;

import com.datacampus.biohealth2.entity.BeverageInformation;
import com.datacampus.biohealth2.entity.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
@Getter @Setter

public class BeverageIntakeDto {
    private Long intakeId;

    private Member memberId;

    private BeverageInformation beverageId;

    private LocalDateTime intakeTime;


}
