package com.nyoba.nyicilprojek.controllers.divkeasramaan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nyoba.nyicilprojek.models.divkeasramaan.MemberDivKeasramaan;
import com.nyoba.nyicilprojek.models.divkeasramaan.MemberDormitory;
import com.nyoba.nyicilprojek.repository.MemberRepository;
import com.nyoba.nyicilprojek.repository.divitionrepository.divkeasramaan.MemberDivKeasramaanRepository;
import com.nyoba.nyicilprojek.repository.divitionrepository.divkeasramaan.MemberDormitoryRepository;

@Controller
@RequestMapping("/divisi/keasramaan")
public class DivKeasramaanController {
    @Autowired
    private MemberDivKeasramaanRepository memberDivKeasramaanRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberDormitoryRepository memberDormitoryRepository;

    @GetMapping("/")
    public String home(){
        return "divkeasramaan/index";
    }
    @GetMapping("/list/")
    public String list(Model model){
        model.addAttribute("member", memberDivKeasramaanRepository.findAll());
        return "divkeasramaan/list";
    }
    @GetMapping("/add/")
    public String addMember(Model model){
        MemberDivKeasramaan member=new MemberDivKeasramaan();
        model.addAttribute("add", member);
        model.addAttribute("member", memberRepository.findAll());
        return "divkeasramaan/add";
    }
    @PostMapping("/save")
    public String saveMember(MemberDivKeasramaan member){
        memberDivKeasramaanRepository.save(member);
        return "redirect:/divisi/keasramaan/add/";
    }
    @GetMapping("/delete/{id}")
    public String deleteString(@PathVariable(value = "id")Long id,Model model){
        memberDivKeasramaanRepository.deleteById(id);
        return "redirect:/divisi/keasramaan/list/";
    }
    @GetMapping("/update/{id}")
    public String updateString(@PathVariable(value = "id")Long id,Model model){
        model.addAttribute("update", memberDivKeasramaanRepository.getReferenceById(id));
        return "divkeasramaan/update";
    }

    // anggota asrama
    @GetMapping("/list-penghuni/")
    public String listPenghuni(Model model){
        model.addAttribute("member", memberDormitoryRepository.findAll());
        return "divkeasramaan/list-penghuni";
    }
    @GetMapping("/add-penghuni/")
    public String addPenghuni(Model model){
        MemberDormitory member=new MemberDormitory();
        model.addAttribute("add", member);
        model.addAttribute("member", memberRepository.findAll());
        return "divkeasramaan/add-penghuni";
    }
    @PostMapping("/save-penghuni")
    public String savePenghuni(MemberDormitory member){
        memberDormitoryRepository.save(member);
        return "redirect:/divisi/keasramaan/add-penghuni/";
    }
    @GetMapping("/delete-penghuni/{id}")
    public String deletePenghuni(@PathVariable(value = "id")Long id,Model model){
        memberDormitoryRepository.deleteById(id);
        return "redirect:/divisi/keasramaan/list-penghuni/";
    }
    @GetMapping("/update-penghuni/{id}")
    public String updatePenghuni(@PathVariable(value = "id")Long id,Model model){
        model.addAttribute("update", memberDormitoryRepository.getReferenceById(id));
        return "divkeasramaan/update-penghuni";
    }
}
