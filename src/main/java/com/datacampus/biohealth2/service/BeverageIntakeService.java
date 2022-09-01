package com.datacampus.biohealth2.service;

import com.datacampus.biohealth2.dto.BeverageIntakeDto;
import com.datacampus.biohealth2.entity.BeverageIntake;
import com.datacampus.biohealth2.repository.BeverageIntakeRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class BeverageIntakeService {
    private final BeverageIntakeRepository beverageIntakeRepository;//이거 빼먹으면 안되용
    //객체를 생성과 동시에 의존성을 주입해서 사용하는 것이기 때문에 반드시 사용해야한다.
    public Long saveBeverageIntake(BeverageIntakeDto beverageIntakeDto){
        BeverageIntake beverageIntake = beverageIntakeDto.createBeverageIntake();
        beverageIntakeRepository.save(beverageIntake);
        return beverageIntake.getIntakeId();
    }
}
