package com.salim.systempub.controllers;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salim.systempub.entities.chamberlain.Chamberlain;
import com.salim.systempub.services.chamberlain.ChamberlainService;

@Controller
@RequestMapping("/bendahara")
public class BendaharaController {

    @Autowired
    ChamberlainService chamberlainService;

    @GetMapping("/")
    public String home(Model model) {
        return chamberlainService.home(model);
    }
    @GetMapping("/list/")
    public String listPendapatanPengeluaran(Model model){
        return chamberlainService.expenseIncomeList(model);
    }
    @GetMapping("/add/")
    public String addData(Model model){
        return chamberlainService.add(model);
    }
    @GetMapping("/delete/v1/{id}")
    public String delete(@PathVariable(value = "id")Long id,Model model){
        return chamberlainService.delete(id, model);
    }
    @GetMapping("/delete/v2/{id}")
    public String delete2String(@PathVariable(value = "id")Long id,Model model){
        return chamberlainService.deleteBalance(id, model);
    }
    @PostMapping("/save")
    public String save(Chamberlain chamberlain){
        return chamberlainService.save(chamberlain);
    }
}
