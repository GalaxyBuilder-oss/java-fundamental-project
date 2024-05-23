package com.salim.systempub.controllers.divkeasramaan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.salim.systempub.dto.MemberRequestDto;
import com.salim.systempub.dto.divkeasramaan.BoarderRequestDto;
import com.salim.systempub.services.divitions.divkeasramaan.DivKeasramaanService;

@Controller
@RequestMapping("/divisi/keasramaan")
public class DivKeasramaanController {

    @Autowired
    private DivKeasramaanService divKeasramaanService;

    @GetMapping("/")
    public String home(Model model) {
        return divKeasramaanService.home(model);
    }

    @GetMapping("/list/")
    public String list(Model model) {
        return divKeasramaanService.list(model);
    }

    @GetMapping("/add/")
    public String add(Model model) {
        return divKeasramaanService.add(model);
    }

    @PostMapping("/save")
    public String save(MemberRequestDto dto) {
        return divKeasramaanService.save(dto);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id, Model model) {
        return divKeasramaanService.delete(id, model);
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Long id, Model model) {
        return divKeasramaanService.update(id, model);
    }

    // anggota asrama
    @GetMapping("/list-penghuni/")
    public String listBoarder(Model model) {
        return divKeasramaanService.listBoarder(model);
    }

    @GetMapping("/add-penghuni/")
    public String addBoarder(Model model) {
        return divKeasramaanService.addBoarder(model);
    }

    @PostMapping("/save-penghuni")
    public String saveBoarder(BoarderRequestDto dto) {
        return divKeasramaanService.saveBoarder(dto);
    }

    @GetMapping("/delete-penghuni/{id}")
    public String deleteBoarder(@PathVariable(value = "id") Long id, Model model) {
        return divKeasramaanService.deleteBoarder(id, model);
    }

    @GetMapping("/update-penghuni/{id}")
    public String updateBoarder(@PathVariable(value = "id") Long id, Model model) {
        return divKeasramaanService.updateBoarder(id, model);
    }
}
