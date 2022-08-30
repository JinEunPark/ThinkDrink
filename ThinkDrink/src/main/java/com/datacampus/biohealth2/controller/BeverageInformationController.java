package com.datacampus.biohealth2.controller;

import com.datacampus.biohealth2.dto.BeverageFormDto;
import com.datacampus.biohealth2.service.BeverageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Controller//반드시 추가해야 mapping 이 진행된다 진은아 제발
@RequiredArgsConstructor
public class BeverageInformationController {
    private final BeverageService beverageService;


    @GetMapping(value="/show")
    public String getBeverageInformation(Model model){
        return "tables";
    }

    @GetMapping(value="beverage/new")
    public String beverageInformationForm(Model model){
        model.addAttribute("beverageFormDto", new BeverageFormDto());
        return "beverage/beverageForm";
    }

    @PostMapping(value="beverage/new/{beverageFormDto.id}")
    public String beverageNew(BeverageFormDto beverageFormDto, BindingResult bindingResult, Model model,
                              @RequestParam("BeverageImgFile")List<MultipartFile> beverageImgFileList){
        if(bindingResult.hasErrors()){
            return "beverage/beverageForm";

        }
        if(beverageImgFileList.get(0).isEmpty()&& beverageFormDto.getId()==null){
            model.addAttribute("errorMessage","첫번째 상품 이미지는 필수 입력란입니다.");
            return "beverage/beverageForm";
        }
        try{
            beverageService.saveBeverage(beverageFormDto,beverageImgFileList);
        }catch (Exception e){
            model.addAttribute("errorMessage","음료등록중 오류가 발생하였습니다");
            return "beverage/beverageForm";
        }
        return "redirect:/";
    }
}
