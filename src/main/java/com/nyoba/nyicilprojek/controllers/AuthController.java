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
public class AuthController {

    @Autowired
    private MemberService bukuService;

    @GetMapping
    public String all(Model model) {
        return bukuService.showAll(model);
    }
    @GetMapping("/add")
    public String add(Model model) {
        if (AuthService.isAdminLogin) return bukuService.add(model);
        else return "redirect:/login";
    }
    @PostMapping("/save")
    public String save(Member buku, Model model) {
        if (AuthService.isAdminLogin) return bukuService.save(buku, model);
        else return "redirect:/login";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") UUID id, Model model) {
        if (AuthService.isAdminLogin) return bukuService.delete(id, model);
        else return "redirect:/login";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable(value = "id") UUID id, Model model) {
        if (AuthService.isAdminLogin) return bukuService.update(id,model);
        else return "redirect:/login";
    }
    @PostMapping("/saveUpdate")
    public String saveUpdaString(Member buku) {
        if (AuthService.isAdminLogin) return bukuService.saveUpdate(buku);
        else return "redirect:/";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/loginin")
    public String loginProgress(@RequestBody()String data,Model model){
        System.out.println(data.split("&")[0].replace("username=", "")+"+"+data.split("&")[1].replace("password=", ""));
        return AuthService.authLogin(data.split("&")[0].replace("username=", ""), data.split("&")[0].replace("password=", ""), model);
        // return "redirect:/";
    }
    @PostMapping("/")
    public String find(@RequestBody String name, Model model) {
        return bukuService.find(name, model);
    }
    @GetMapping("/logout")
    public String logout() {
        AuthService.isAdminLogin=false;
        AuthService.isUserLogin=false;
        return "redirect:/";
    }
}
