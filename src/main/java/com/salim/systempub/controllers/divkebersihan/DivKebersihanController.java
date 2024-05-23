package com.salim.systempub.controllers.divkebersihan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salim.systempub.entities.divkebersihan.MemberDivKebersihan;
import com.salim.systempub.entities.divkebersihan.Piket;
import com.salim.systempub.repositories.MemberRepository;
import com.salim.systempub.repositories.RoomRepository;
import com.salim.systempub.repositories.divitionrepository.divkebersihan.MemberDivKebersihanRepository;
import com.salim.systempub.repositories.divitionrepository.divkebersihan.PiketRepository;

@Controller
@RequestMapping("/divisi/kebersihan")
public class DivKebersihanController {
    @Autowired
    private MemberDivKebersihanRepository memberDivKebersihanRepository;
    @Autowired
    private PiketRepository piketRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("addMember", new MemberDivKebersihan());
        model.addAttribute("memberDiv", memberDivKebersihanRepository.findAll());
        model.addAttribute("member", memberRepository.findAll());
        model.addAttribute("piket", piketRepository.findAll());
        model.addAttribute("addPiket", new Piket());
        model.addAttribute("room", roomRepository.findAll());
        return "divkebersihan/index";
    }
    @GetMapping("/list/")
    public String list(Model model){
        return "divkebersihan/list";
    }
    @GetMapping("/add/")
    public String addMember(Model model){
        model.addAttribute("addMember", new MemberDivKebersihan());
        model.addAttribute("member", memberRepository.findAll());
        return "divkebersihan/add";
    }
    @PostMapping("/save")
    public String saveMember(MemberDivKebersihan member){
        memberDivKebersihanRepository.save(member);
        return "redirect:/divisi/kebersihan/";
    }
    @GetMapping("/delete/{id}")
    public String deleteString(@PathVariable(value = "id")Long id,Model model){
        memberDivKebersihanRepository.deleteById(id);
        return "redirect:/divisi/kebersihan/";
    }
    @GetMapping("/update/{id}")
    public String updateString(@PathVariable(value = "id")Long id,Model model){
        model.addAttribute("member", memberRepository.findAll());
        model.addAttribute("update", memberDivKebersihanRepository.getReferenceById(id));
        return "divkebersihan/update";
    }

    // Jadwal Piket
    @GetMapping("/list-piket/")
    public String listPiket(Model model){
        model.addAttribute("piket", piketRepository.findAll());
        return "divkebersihan/list-piket";
    }
    @GetMapping("/add-piket/")
    public String addPiket(Model model){
        model.addAttribute("member", memberRepository.findAll());
        model.addAttribute("addPiket", new Piket());
        model.addAttribute("room", roomRepository.findAll());
        return "divkebersihan/add-piket";
    }
    @PostMapping("/save-piket")
    public String savePiket(Piket piket){
        piketRepository.save(piket);
        return "redirect:/divisi/kebersihan/";
    }
    @GetMapping("/delete-piket/{id}")
    public String deletePiket(@PathVariable(value = "id")Long id,Model model){
        piketRepository.deleteById(id);
        return "redirect:/divisi/kebersihan/";
    }
    @GetMapping("/update-piket/{id}")
    public String updatePiket(@PathVariable(value = "id")Long id,Model model){
        model.addAttribute("member", memberRepository.findAll());
        model.addAttribute("update", memberDivKebersihanRepository.getReferenceById(id));
        return "divkebersihan/update-piket";
    }

}
