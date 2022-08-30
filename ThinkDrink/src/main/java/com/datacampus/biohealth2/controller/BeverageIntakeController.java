package com.datacampus.biohealth2.controller;

import com.datacampus.biohealth2.entity.BeverageInformation;
import com.datacampus.biohealth2.entity.CafeInformation;
import com.datacampus.biohealth2.entity.Member;
import com.datacampus.biohealth2.repository.BeverageInformationRepository;
import com.datacampus.biohealth2.repository.CafeRepository;
import com.datacampus.biohealth2.repository.MemberRepository;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Service
@RequestMapping(value="/members/IntakeBeverage")
@RequiredArgsConstructor
@Slf4j
public class BeverageIntakeController {

    private final BeverageInformationRepository beverageInformationRepository;
    private final CafeRepository cafeRepository;

    private final MemberRepository memberRepository;

    @GetMapping(value="/intakeWay")
    public String decisionWay(){
        return "beverage/BeverageIntakeWay";
    }

    @GetMapping(value="intakeWay/manual")
    public String intakeManualGet(@AuthenticationPrincipal UserDetails userDetails, Model model){
        List<BeverageInformation> beverageInformationList = beverageInformationRepository.findAll();
        List<CafeInformation> cafeInformationList = cafeRepository.findAll();
        List<String> cafeNameList = new ArrayList<>();
        List<String> beverageNameList = new ArrayList<>();

        for(CafeInformation cafeInformation : cafeInformationList){
            cafeNameList.add(cafeInformation.getCafeName());
        }

        String userName = userDetails.getUsername();

        model.addAttribute("userName",userName);
        model.addAttribute("beverageInformationList", beverageInformationList);
        model.addAttribute("cafeInformationList",cafeInformationList);

        return "beverage/BeverageIntakeManual";
    }

    @GetMapping(value="/intakeWay/manual/getIntake")
    public String intakeManualPost(@AuthenticationPrincipal UserDetails userDetails, Long beverageId, Model model){
        String userName = userDetails.getUsername();
        model.addAttribute("userName",userName);
        Member member = memberRepository.findByEmail(userName);
        Optional<BeverageInformation> optionalBeverageInformation = beverageInformationRepository.findById(beverageId);
        BeverageInformation beverageInformation = optionalBeverageInformation.get();
        model.addAttribute("beverageInformation",beverageInformation);


        return "beverage/getIntake";
    }
}
