package com.datacampus.biohealth2.controller;

import com.datacampus.biohealth2.entity.Member;
import com.datacampus.biohealth2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
    private final MemberRepository memberRepository;


    @GetMapping("/")
    public String getHome(Model model, Principal principal){

      String name = principal.getName();
      Member member = memberRepository.findByName(name);
      model.addAttribute("member",member);

        return "index";
    }
}
