package com.nyoba.nyicilprojek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nyoba.nyicilprojek.models.Secretary;
import com.nyoba.nyicilprojek.repository.secretary.SecretaryRepository;

@Controller
@RequestMapping("/sekretaris")
public class SecretaryController {

    @Autowired
    private SecretaryRepository secretaryRepository;
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("isLogin",true);
        return "secretary/index";
    }
    @GetMapping("/agenda/")
    public String agenda(Model model){
        model.addAttribute("agenda", secretaryRepository.findAll());
        return "secretary/list-agenda";
    }
    @GetMapping("/add/")
    public String addAgenda(Model model){
        Secretary agenda=new Secretary();
        model.addAttribute("add", agenda);
        return "secretary/add-agenda";
    }
    @PostMapping("/save")
    public String saveAgenda(Secretary agenda){
        secretaryRepository.save(agenda);
        return "redirect:/sekretaris/add/";
    }
    @GetMapping("/delete/{id}")
    public String deleteString(@PathVariable(value = "id")Long id,Model model){
        secretaryRepository.deleteById(id);
        return "redirect:/sekretaris/agenda/";
    }
}