package com.salim.systempub.controllers.divkerohanian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salim.systempub.dto.MemberRequestDto;
import com.salim.systempub.dto.divkerohanian.DataPUBRequestDto;
import com.salim.systempub.services.divitions.divkerohanian.DivKerohanianService;

@Controller
@RequestMapping("/divisi/kerohanian")
public class DivKerohanianController {

    @Autowired
    private DivKerohanianService divKerohanianService;

    @GetMapping("/")
    public String home(Model model) {
        return divKerohanianService.home(model);
    }

    @GetMapping("/list/")
    public String list(Model model) {

        return divKerohanianService.list(model);
    }

    @GetMapping("/add/")
    public String addMember(Model model) {
        return divKerohanianService.addMember(model);
    }

    @PostMapping("/save")
    public String saveMember(MemberRequestDto dto) {
        return divKerohanianService.saveMember(dto);
    }

    @GetMapping("/delete/{id}")
    public String deleteMember(@PathVariable(value = "id") Long id, Model model) {
        return divKerohanianService.deleteMember(id, model);
    }

    @GetMapping("/update/{id}")
    public String update(Long id, Model model) {
        return divKerohanianService.update(id, model);
    }

    // Sistem Poin dan Hafalan Di PUB
    @GetMapping("/list-data/")
    public String listData(Model model) {

        return divKerohanianService.listData(model);
    }

    @GetMapping("/add-data/")
    public String addData(Model model) {
        return divKerohanianService.addData(model);
    }

    @PostMapping("/save-data")
    public String saveData(DataPUBRequestDto data) {
        return divKerohanianService.saveData(data);
    }

    @GetMapping("/update-data/{id}")
    public String updateData(Long id, Model model) {
        return divKerohanianService.updateData(id, model);
    }

    @GetMapping("/delete-data/{id}")
    public String deleteData(@PathVariable(value = "id") Long id, Model model) {
        return divKerohanianService.deleteData(id, model);
    }
}
