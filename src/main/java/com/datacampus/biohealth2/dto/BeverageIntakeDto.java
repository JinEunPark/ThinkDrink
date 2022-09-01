package com.datacampus.biohealth2.dto;

import com.datacampus.biohealth2.entity.BeverageInformation;
import com.datacampus.biohealth2.entity.BeverageIntake;
import com.datacampus.biohealth2.entity.HealthInformation;
import com.datacampus.biohealth2.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
@Getter @Setter
@NoArgsConstructor

public class BeverageIntakeDto {
    private Long intakeId;

    private Member memberId;

    private BeverageInformation beverageId;

    private static ModelMapper modelMapper = new ModelMapper();
    public BeverageIntake createBeverageIntake(){
        return modelMapper.map(this, BeverageIntake.class);
    }

    public static BeverageIntakeDto of(BeverageIntake beverageIntake){
        return modelMapper.map(beverageIntake, BeverageIntakeDto.class);
    }

}
