package com.salim.systempub.controllers;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salim.systempub.services.MainService;
import com.salim.systempub.services.member.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MainController {

    @Autowired
    MainService mainService;

    @Autowired
    MemberService memberService;

    @GetMapping("/")
    public String home(Model model) {
        return mainService.home(model);
    }

    @GetMapping("/divisi/")
    public String divitionList() {
        return mainService.divitionList();
    }

    @GetMapping("/find")
    public String find(@RequestParam(value = "nama") String name, Model model) {

        return memberService.find(name, model);
    }

    @GetMapping("/login")
    public String login() {
        return mainService.Login();
    }

    @GetMapping("/logout")
    public String customLogout(HttpServletRequest request, HttpServletResponse response) {
        return mainService.customLogout(request, response);
    }

    @GetMapping("/denied")
    public String costumDenied(HttpServletRequest request, HttpServletResponse response) {
        return mainService.customDenied(request, response);
    }

    @GetMapping("/calladmin")
    public String callAdmin(Model model) {
        return mainService.callAdmin(model);
    }

    @PostMapping("/calladmin")
    public String sendToAdmin(@RequestParam("name") String name, @RequestParam("number") String number,
            @RequestParam("message") String message, Model model) {
        return mainService.sendToAdmin(name, number, message, model);
    }

    @GetMapping("/about/")
    public String aboutPage() {
        return mainService.aboutPage();
    }
}
