package com.datacampus.biohealth2.controller;

import com.datacampus.biohealth2.repository.HealthInformationRepository;
import com.datacampus.biohealth2.repository.MemberRepository;
import com.datacampus.biohealth2.repository.PerDayNutritionRepository;
import groovy.util.logging.Slf4j;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
//건강정보랑 연동해서 음료수를 처먹은 현황과 일일 권장 섭취량을 보여줄것
//이왕이면 json 방식으로 rest하게 작성할 것

public class PerDayNutritionController {

    private final PerDayNutritionRepository perDayNutritionRepository;
    private final HealthInformationRepository healthInformationRepository;
    private final MemberRepository memberRepository;


}
