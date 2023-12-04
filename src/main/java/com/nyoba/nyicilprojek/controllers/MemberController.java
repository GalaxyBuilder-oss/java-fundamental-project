package com.nyoba.nyicilprojek.controllers;

import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nyoba.nyicilprojek.config.AuthConfig;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MemberController extends AuthConfig {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("isLogin", true);
        return "index";
    }
    @GetMapping("/divisi/")
    public String divitionList(){
        return "list-divisi";
    }
    @GetMapping("/find")
    public String find(@RequestParam(value = "nama") String name, Model model) {
        
        return memberService.find(name, model);
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/logout")
    public String customLogout(HttpServletRequest request, HttpServletResponse response){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null){
        new SecurityContextLogoutHandler().logout(request, response, authentication);
    }
    return "redirect:/login";
    }
    @GetMapping("/denied")
    public String costumDenied(){
        return "page-error";
    }
}
