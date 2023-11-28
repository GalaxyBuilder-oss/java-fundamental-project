package com.nyoba.nyicilprojek.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.nyoba.nyicilprojek.config.AuthConfig;

@Controller
public class MemberController extends AuthConfig {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("isLogin", isLogin);
        return "index";
    }
    @GetMapping("/divition-list/")
    public String divitionList(){
        if(isLogin) return "divition-list";
        return "login";
    }
    @GetMapping("/login/")
    public String login(){
        if(isLogin) return "redirect:/";
        return "login";
    }
    @PostMapping("/loginin")
    public String loginProgress(@RequestBody()String data,Model model){
        System.out.println(data.split("&")[0].replace("username=", "")+"+"+data.split("&")[1].replace("password=", ""));
        return authService.authLogin(data.split("&")[0].replace("username=", ""),data.split("&")[1].replace("password=", ""),model);
    }
    @GetMapping("/find")
    public String find(@RequestParam(value = "nama") String name, Model model) {
        return memberService.find(name, model);
    }
    @GetMapping("/logout")
    public String logout() {
        if(isAdminLogin) isAdminLogin=false;
        if(isUserLogin) isUserLogin=false;
        isLogin=false;
        return "redirect:/";
    }
}
