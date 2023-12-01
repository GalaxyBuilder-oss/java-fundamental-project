package com.nyoba.nyicilprojek.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nyoba.nyicilprojek.config.AuthConfig;

@Controller
public class MemberController extends AuthConfig {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("isLogin", true);
        return "index";
    }
    @GetMapping("/divition-list/")
    public String divitionList(){
        return "divition-list";
    }
    @GetMapping("/find")
    public String find(@RequestParam(value = "nama") String name, Model model) {
        return memberService.find(name, model);
    }
}
