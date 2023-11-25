package com.nyoba.nyicilprojek.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.nyoba.nyicilprojek.models.Member;
import com.nyoba.nyicilprojek.services.MemberService;
import com.nyoba.nyicilprojek.services.AuthService;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public String all(Model model) {
        return memberService.showAll(model);
    }
    @GetMapping("/add")
    public String add(Model model) {
        if(AuthService.isAdminLogin) return memberService.add(model);
        return "redirect:/login";
    }
    @PostMapping("/save")
    public String save(Member member, Model model) {
        if(AuthService.isAdminLogin) return memberService.save(member, model);
        return "redirect:/login";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name="id")UUID id, Model model) {
        if(AuthService.isAdminLogin) return memberService.delete(id, model);
        return "redirect:/login";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable(name="id")UUID id, Model model) {
        if(AuthService.isAdminLogin) return memberService.update(id,model);
        return "redirect:/login";
    }
    @PostMapping("/saveUpdate")
    public String saveUpdaString(Member member) {
        if(AuthService.isAdminLogin) return memberService.saveUpdate(member);
        return "redirect:/";
    }
    @GetMapping("/login")
    public String login(){
        if(AuthService.isAdminLogin) return "redirect:/";
        return "login";
    }
    @PostMapping("/loginin")
    public String loginProgress(@RequestBody()String data,Model model){
        System.out.println(data.split("&")[0].replace("username=", "")+"+"+data.split("&")[1].replace("password=", ""));
        return AuthService.authLogin(data.split("&")[0].replace("username=", ""), data.split("&")[0].replace("password=", ""), model);
    }
    @GetMapping("/find")
    public String find(@RequestParam(value = "nama") String name, Model model) {
        return memberService.find(name, model);
    }
    @GetMapping("/logout")
    public String logout() {
        if(AuthService.isAdminLogin) AuthService.isAdminLogin=false;
        if(AuthService.isUserLogin) AuthService.isUserLogin=false;
        return "redirect:/";
    }
}
