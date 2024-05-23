package com.salim.systempub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salim.systempub.entities.Secretary;
import com.salim.systempub.services.secretary.SecretaryService;

@Controller
@RequestMapping("/sekretaris")
public class SecretaryController {

    @Autowired
    SecretaryService secretaryService;

    @GetMapping("/")
    public String home(Model model) {
        return secretaryService.home(model);
    }
    @GetMapping("/agenda/")
    public String agenda(Model model){
        return secretaryService.agendaList(model);
    }
    @GetMapping("/add/")
    public String addAgenda(Model model){
        return secretaryService.add(model);
    }
    @PostMapping("/save")
    public String saveAgenda(Secretary agenda){
        return secretaryService.save(agenda);
    }
    @GetMapping("/delete/{id}")
    public String deleteString(@PathVariable(value = "id")Long id,Model model){
        return secretaryService.delete(id, model);
    }
}