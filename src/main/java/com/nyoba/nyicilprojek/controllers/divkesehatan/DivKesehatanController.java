package com.nyoba.nyicilprojek.controllers.divkesehatan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nyoba.nyicilprojek.models.divkesehatan.Farmacy;
import com.nyoba.nyicilprojek.models.divkesehatan.MemberDivKesehatan;
import com.nyoba.nyicilprojek.repository.MemberRepository;
import com.nyoba.nyicilprojek.repository.divitionrepository.divkesehatan.FarmacyRepository;
import com.nyoba.nyicilprojek.repository.divitionrepository.divkesehatan.MemberDivKesehatanRepository;

@Controller
@RequestMapping("/divisi/kesehatan")
public class DivKesehatanController {
    @Autowired
    private MemberDivKesehatanRepository memberDivKesehatanRepository;
    @Autowired
    private FarmacyRepository farmacyRepository;
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/")
    public String home(){
        return "divkesehatan/index";
    }
    @GetMapping("/list/")
    public String list(Model model){
        model.addAttribute("member", memberDivKesehatanRepository.findAll());
        return "divkesehatan/list";
    }
    @GetMapping("/add/")
    public String addMember(Model model){
        MemberDivKesehatan member=new MemberDivKesehatan();
        model.addAttribute("add", member);
        model.addAttribute("member", memberRepository.findAll());
        return "divkesehatan/add";
    }
    @PostMapping("/save")
    public String saveMember(MemberDivKesehatan member){
        memberDivKesehatanRepository.save(member);
        return "redirect:/divisi/kesehatan/add/";
    }
    @GetMapping("/delete/{id}")
    public String deleteString(@PathVariable(value = "id")Long id,Model model){
        memberDivKesehatanRepository.deleteById(id);
        return "redirect:/divisi/kesehatan/list/";
    }
    @GetMapping("/update/{id}")
    public String updateString(@PathVariable(value = "id")Long id,Model model){
        model.addAttribute("update", memberDivKesehatanRepository.getReferenceById(id));
        return "divkesehatan/update";
    }

    // Stok Obat Session
    @GetMapping("/stok-obat/")
    public String listMedicine(Model model){
        model.addAttribute("medicine", farmacyRepository.findAll());
        return "divkesehatan/list-medicine";
    }
    @GetMapping("/add-obat/")
    public String addMedicine(Model model){
        Farmacy medicine=new Farmacy();
        model.addAttribute("add", medicine);
        return "divkesehatan/add-stock";
    }
    @PostMapping("/save-stock")
    public String saveObat(Farmacy medicine){
        farmacyRepository.save(medicine);
        return "redirect:/divisi/kesehatan/add-obat/";
    }
    @GetMapping("/delete-obat/{id}")
    public String deleteMedicine(@PathVariable(value = "id")Long id,Model model){
        farmacyRepository.deleteById(id);
        return "redirect:/divisi/kesehatan/stok-obat/";
    }
    @GetMapping("/update-obat/{id}")
    public String updateMedicine(@PathVariable(value = "id")Long id,Model model){
        model.addAttribute("update", farmacyRepository.getReferenceById(id));
        return "div/kesehatan/update-obat/";
    }
}
