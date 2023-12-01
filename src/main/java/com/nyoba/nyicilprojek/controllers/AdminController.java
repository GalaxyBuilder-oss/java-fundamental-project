package com.nyoba.nyicilprojek.controllers;

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
@RequestMapping("/admin")
public class AdminController extends AuthConfig {

    @Autowired
    private AdminService adminService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("isLogin", true);
        return "/admin/index";
    }
    @GetMapping("/scholar-list/")
    public String all(Model model) {
         return adminService.showAll(model);
    }
    @GetMapping("/add/")
    public String add(Model model) {
         return adminService.add(model);
    }
    @PostMapping("/save")
    public String save(Member member, Model model) {
         return adminService.save(member, model);
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value="id")Long id, Model model) {
         return adminService.delete(id, model);
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable(name="id")Long id, Model model) {
         return adminService.update(id,model);
    }
    @PostMapping("/saveUpdate")
    public String saveUpdaString(Member member) {
         return adminService.saveUpdate(member);
    }
}