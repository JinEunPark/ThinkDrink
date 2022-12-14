package com.datacampus.biohealth2.controller;

import com.datacampus.biohealth2.constant.Activity;
import com.datacampus.biohealth2.constant.Gender;
import com.datacampus.biohealth2.dto.*;
import com.datacampus.biohealth2.entity.HealthInformation;
import com.datacampus.biohealth2.entity.Member;
import com.datacampus.biohealth2.entity.PerDayNutrition;
import com.datacampus.biohealth2.repository.HealthInformationRepository;
import com.datacampus.biohealth2.repository.MemberRepository;
import com.datacampus.biohealth2.repository.PerDayNutritionRepository;
import com.datacampus.biohealth2.serializer.CustomSerializer;
import com.datacampus.biohealth2.service.HealthInformationService;
import com.datacampus.biohealth2.service.PerDayNutritionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import groovy.util.logging.Slf4j;
import groovyjarjarantlr4.v4.codegen.model.OutputModelObject;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

import static com.datacampus.biohealth2.constant.Activity.activity;

@Controller
@Service
@RequestMapping(value="/members/healthInformation")
@RequiredArgsConstructor
@Slf4j
public class HealthInformationController {

    private final HealthInformationService healthInformationService;

    private final HealthInformationRepository healthInformationRepository;
    private final MemberRepository memberRepository;

    private final PerDayNutritionService perDayNutritionService;

    private final PerDayNutritionRepository perDayNutritionRepository;


    @ModelAttribute("genders")
    public Gender[] genders(){
        return Gender.values();
    }

    @ModelAttribute("activityTypes")
    public Activity[] activities(){
        return Activity.values();
    }

    @GetMapping(value="/new")
    public String getHealthInformation(@AuthenticationPrincipal UserDetails userDetails, Model model){
            model.addAttribute("healthInformationFormDto", new HealthInformationFormDto());//loadByUsername?????? ???????????? ????????? ??????????????????.
            model.addAttribute("userName", userDetails.getUsername());
            String userEmail = userDetails.getUsername();
            Member member = memberRepository.findByEmail(userEmail);

            model.addAttribute("member",member);


        return "healthInformation/healthInformationForm";
    }

    @PostMapping(value="/new")
    public String newHealthInformation(@ModelAttribute HealthInformationFormDto healthInformationFormDto, BindingResult bindingResult,
                                       Model model, @AuthenticationPrincipal UserDetails userDetails){


         String userEmail = userDetails.getUsername();
        System.out.println(userEmail);
         Member member = memberRepository.findByEmail(userEmail);
        healthInformationFormDto.setMember(member);//application context ???????????? ?????? login ??? ????????? ????????? ?????????.


        if(bindingResult.hasErrors()){
            System.out.println("has1");
            return "healthInformation/healthInformationForm";
        }
        try{
            HealthInformation healthInformation = HealthInformation.createHealthInformation(healthInformationFormDto);
            PerDayNutritionDto perDayNutritionDto = perDayNutritionService.getPerDayFromHealthInformation(healthInformation);
            PerDayNutrition perDayNutrition = perDayNutritionDto.createPerDayNutrition();


            healthInformationService.saveHealthInformation(healthInformation);//?????? ?????? ???????????? ??????
            perDayNutritionService.savePerDayNutrition(perDayNutrition);
            System.out.println("has2");


        } catch(IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            System.out.println("has3");
            return "healthInformation/healthInformationForm";
        }
        System.out.println("hsssssssssssssssssssssssssssssssssss");

        return "redirect:/";
    }

    @GetMapping("/show")
    public String showHealthInformation(@AuthenticationPrincipal UserDetails userDetails, Model model) throws JsonProcessingException {

        String userEmail = userDetails.getUsername();
        Member member = memberRepository.findByEmail(userEmail);
        HealthInformation healthInformation = healthInformationRepository.findByMember_Id(member.getId());
        model.addAttribute("userName",member.getName());
        model.addAttribute("user_weight",healthInformation.getWeight());
        model.addAttribute("user_height",healthInformation.getHeight());
        model.addAttribute("user_gender",healthInformation.getGender());
        model.addAttribute("user_activity",healthInformation.getActivityType());
        model.addAttribute("user_age",healthInformation.getAge());

        PerDayNutrition perDayNutrition  = perDayNutritionRepository
                .findPerDayNutritionByHealthInformation_Id(healthInformation.getId());
        PerDayNutritionDto perDayNutritionDto = perDayNutritionService.getPerDayNutritionDto(perDayNutrition);
//
//
//        ObjectMapper objectMapper = CustomSerializer.getCustomObjectMapper();
//
//        String perDayNutritionJson = objectMapper.writerWithDefaultPrettyPrinter()
//                .writeValueAsString(perDayNutritionDto);
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("\'");
//        stringBuilder.append(perDayNutritionJson);
//        stringBuilder.append("\'");
//        perDayNutritionJson = stringBuilder.toString();
        SendToScriptDto perDay = new SendToScriptDto(perDayNutritionDto);
        model.addAttribute("perDay",perDay);
        System.out.println(perDay);

        return "healthInformation/showHealthInformation";
    }
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
