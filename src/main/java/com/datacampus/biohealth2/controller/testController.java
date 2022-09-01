package com.datacampus.biohealth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/test")
public class testController {
    @GetMapping
    public String getTest(){
        return "hello world";
    }

}
