package com.nyoba.nyicilprojek.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nyoba.nyicilprojek.config.AuthConfig;
import com.nyoba.nyicilprojek.models.Chamberlain;

@Controller
@RequestMapping("/bendahara")
public class BendaharaController extends AuthConfig {

    @GetMapping("/")
    public String home(Model model) {
        if(isAdminLogin&&role.equalsIgnoreCase("bendahara")){
            model.addAttribute("isLogin",isAdminLogin);
            return "bendahara/index";
        }
        else if(isAdminLogin) return "redirect:/admin/";
        else if(isUserLogin) return "redirect:/user/";
        return "redirect:/login/";
    }
    @GetMapping("/list/")
    public String listPendapatanPengeluaran(){

        return "bendahara/list";
    }
    @GetMapping("/add/")
    public String addData(Model model){
        // {
            Chamberlain bendahara = new Chamberlain();
            model.addAttribute("isLogin",isAdminLogin);
            model.addAttribute("data",bendahara);
            return "bendahara/add";
        // }
        // return "redirect:/login/";
    }
}
