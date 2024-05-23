package com.salim.systempub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salim.systempub.entities.PPMB;
import com.salim.systempub.services.ppmb.PPMBService;

@Controller
@RequestMapping("/ppmb")
public class PPMBController {

    @Autowired
    PPMBService ppmbService;

    @GetMapping("/")
    public String home(Model model) {

        return ppmbService.home(model);
    }

    @PostMapping("/post")
    public String save(PPMB ppmb) {

        return ppmbService.save(ppmb);
    }

    @GetMapping("/delete/{id}")
    public String deleteString(@PathVariable(value = "id") Long id, Model model) {
        
        return ppmbService.delete(id, model);
    }
}