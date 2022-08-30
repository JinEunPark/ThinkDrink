package com.thinkdring.biohealth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowInfoDrink {
    @GetMapping("tables")
    public String showInfoDrink(){
        return"tables";
    }

}
