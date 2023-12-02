package com.nyoba.nyicilprojek.controllers.divpelatihaninggris;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nyoba.nyicilprojek.models.divpelatihaninggris.MemberDivPelatihanInggris;
import com.nyoba.nyicilprojek.models.divpelatihaninggris.Vocab;
import com.nyoba.nyicilprojek.repository.MemberRepository;
import com.nyoba.nyicilprojek.repository.divitionrepository.divpelatihaninggris.MemberDivPelatihanInggrisRepository;
import com.nyoba.nyicilprojek.repository.divitionrepository.divpelatihaninggris.VocabRepository;

@Controller
@RequestMapping("/divisi/pelatihaninggris")
public class DivPelatihanInggrisController {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private VocabRepository vocabRepository;
    @Autowired
    private MemberDivPelatihanInggrisRepository memberDivPelatihanInggrisRepository;
    @GetMapping("/")
    public String home(Model model){
        return "divpelatihaninggris/index";
    }
    @GetMapping("/list/")
    public String list(Model model){
        model.addAttribute("member", memberDivPelatihanInggrisRepository.findAll());
        return "divpelatihaninggris/list";
    }
    @GetMapping("/add/")
    public String addmember(Model model){
        MemberDivPelatihanInggris member=new MemberDivPelatihanInggris();
        model.addAttribute("add", member);
        model.addAttribute("member", memberRepository.findAll());
        return "divpelatihaninggris/add";
    }
    @PostMapping("/save")
    public String save(MemberDivPelatihanInggris member){
        memberDivPelatihanInggrisRepository.save(member);
        return "redirect:/divisi/pelatihaninggris/add/";
    }
    @GetMapping("/delete/{id}")
    public String deleteString(@PathVariable(value = "id")Long id){
        memberDivPelatihanInggrisRepository.deleteById(id);
        return "redirect:/divisi/pelatihaninggris/list/";
    }
    @GetMapping("/update/{id}")
    public String updatetring(@PathVariable(value = "id")Long id,Model model){
        model.addAttribute("update", memberDivPelatihanInggrisRepository.getReferenceById(id));
        return "divpelatihaninggris/update";
    }

    // Vocab Section
    @GetMapping("/list-vocab/")
    public String listVocab(Model model){
        model.addAttribute("member", vocabRepository.findAll());
        return "divpelatihaninggris/list-vocab";
    }
    @GetMapping("/add-vocab/")
    public String addVocab(Model model){
        Vocab member=new Vocab();
        model.addAttribute("add", member);
        model.addAttribute("member", memberRepository.findAll());
        return "divpelatihaninggris/add-vocab";
    }
    @PostMapping("/save-vocab")
    public String saveVocab(Vocab vocab){
        vocabRepository.save(vocab);
        return "redirect:/divisi/pelatihaninggris/add-vocab/";
    }
    @GetMapping("/delete-vocab/{id}")
    public String deleteVocab(@PathVariable(value = "id")Long id){
        vocabRepository.deleteById(id);
        return "redirect:/divisi/pelatihaninggris/list-vocab/";
    }
    @GetMapping("/update-vocab/{id}")
    public String updateVocab(@PathVariable(value = "id")Long id,Model model){
        model.addAttribute("update", vocabRepository.getReferenceById(id));
        return "divpelatihaninggris/update-vocab";
    }
}
