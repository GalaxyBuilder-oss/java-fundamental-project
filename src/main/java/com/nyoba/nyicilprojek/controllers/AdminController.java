package com.nyoba.nyicilprojek.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nyoba.nyicilprojek.config.AuthConfig;
import com.nyoba.nyicilprojek.models.Member;
import com.nyoba.nyicilprojek.services.AdminService;

@Controller
@RequestMapping("/admin2")
public class AdminController extends AuthConfig {

    @Autowired
    private AdminService adminService;

    @GetMapping("/")
    public String home(Model model) {
        if(isAdminLogin){
            model.addAttribute("isLogin", AuthConfig.isAdminLogin);
            return "/admin/index";
        }
        else if(isUserLogin) return "redirect:/user/";
        return "redirect:/login/";
    }
    @GetMapping("/scholar-list/")
    public String all(Model model) {
        if(isAdminLogin) return adminService.showAll(model);
        else if(isUserLogin) return "redirect:/user/";
        return "redirect:/";
    }
    @GetMapping("/add/")
    public String add(Model model) {
        if(isAdminLogin) return adminService.add(model);
        else if(isUserLogin) return "redirect:/user/";
        return "redirect:/login/";
    }
    @PostMapping("/save")
    public String save(Member member, Model model) {
        if(isAdminLogin) return adminService.save(member, model);
        else if(isUserLogin) return "redirect:/user/";
        return "redirect:/login/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value="id")UUID id, Model model) {
        if(isAdminLogin) return adminService.delete(id, model);
        else if(isUserLogin) return "redirect:/user/";
        return "redirect:/login/";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable(name="id")UUID id, Model model) {
        if(isAdminLogin) return adminService.update(id,model);
        else if(isUserLogin) return "redirect:/user/";
        return "redirect:/login/";
    }
    @PostMapping("/saveUpdate")
    public String saveUpdaString(Member member) {
        if(isAdminLogin) return adminService.saveUpdate(member);
        else if(isUserLogin) return "redirect:/user/";
        return "redirect:/";
    }
}