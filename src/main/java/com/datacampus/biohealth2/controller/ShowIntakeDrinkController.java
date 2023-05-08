package com.datacampus.biohealth2.controller;

import com.datacampus.biohealth2.entity.BeverageIntake;
import com.datacampus.biohealth2.repository.BeverageIntakeRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
@Setter
@RequestMapping(value="members/showIntakeBeverage")
public class ShowIntakeDrinkController {

    private final BeverageIntakeRepository beverageIntakeRepository;

    @GetMapping(value="/show")
    public String getTimeStamp(){
        return"Intake/showIntakeBeverage";
    }

    @GetMapping(value="/{timestamp}")
    @ResponseBody
    public List<BeverageIntake> getBeverageIntakeAsTimeStamp(String startTimeStamp, String endTimeStamp, String present){
        return null;

    }


}

