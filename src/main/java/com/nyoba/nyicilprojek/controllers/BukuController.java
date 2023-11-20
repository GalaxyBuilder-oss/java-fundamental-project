package com.nyoba.nyicilprojek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nyoba.nyicilprojek.models.Buku;
import com.nyoba.nyicilprojek.services.BukuService;

@Controller
public class BukuController {

    @Autowired
    BukuService bukuService;

    @GetMapping
    public String all(Model model) {
        return bukuService.showAll(model);
    }
    @GetMapping("/add")
    public String add(Model model) {
        return bukuService.add(model);
    }
    @PostMapping("/save")
    public String save(Buku buku, Model model) {
        return bukuService.save(buku, model);
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id, Model model) {
        return bukuService.delete(id, model);
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Long id, Model model) {
        return bukuService.update(id,model);
    }
    @PostMapping("/saveUpdate")
    public String saveUpdaString(Buku buku) {
        return bukuService.saveUpdate(buku);
    }
    @PostMapping("/")
    public String find(@RequestBody String name, Model model) {
        return bukuService.find(name, model);
    }
}
