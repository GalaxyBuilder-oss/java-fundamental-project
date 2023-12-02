package com.nyoba.nyicilprojek.controllers.divpendidikan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nyoba.nyicilprojek.models.divpendidikan.Kelompok;
import com.nyoba.nyicilprojek.models.divpendidikan.MemberGroup;
import com.nyoba.nyicilprojek.models.divpendidikan.MemberDivPendidikan;
import com.nyoba.nyicilprojek.repository.MemberRepository;
import com.nyoba.nyicilprojek.repository.divitionrepository.divpendidikan.KelompokRepository;
import com.nyoba.nyicilprojek.repository.divitionrepository.divpendidikan.MemberGroupRepository;
import com.nyoba.nyicilprojek.repository.divitionrepository.divpendidikan.MemberDivPendidikanRepository;

@Controller
@RequestMapping("/divisi/pendidikan")
public class DivPendidikanController {

    @Autowired
    private KelompokRepository kelompokRepository;
    @Autowired
    private MemberGroupRepository memberGroupRepository;
    @Autowired
    private MemberDivPendidikanRepository memberDivPendidikanRepository;
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("isLogin",true);
        return "divpendidikan/index";
    }
    @GetMapping("/list/")
    public String memberString(Model model){
        model.addAttribute("member", memberDivPendidikanRepository.findAll());
        return "divpendidikan/list-member";
    }
    @GetMapping("/list-membergroup/")
    public String memberGroupString(Model model){
        model.addAttribute("membergroup", memberGroupRepository.findAll());
        return "divpendidikan/list-membergroup";
    }
    @GetMapping("/list-group/")
    public String groupString(Model model){
        model.addAttribute("group", kelompokRepository.findAll());
        return "divpendidikan/list-group";
    }
    @GetMapping("/add-member/")
    public String addMember(Model model){
        MemberDivPendidikan memberDivPendidikan=new MemberDivPendidikan();
        model.addAttribute("member", memberRepository.findAll());
        model.addAttribute("add", memberDivPendidikan);
        return "divpendidikan/add-member";
    }
    @GetMapping("/add-group/")
    public String addGroup(Model mode){
        Kelompok kelompok=new Kelompok();
        mode.addAttribute("add", kelompok);
        return "divpendidikan/add-group";
    }
    @GetMapping("/add-groupmember/")
    public String addDivMember(Model model){
        MemberGroup memberGroup=new MemberGroup();
        model.addAttribute("member", memberRepository.findAll());
        model.addAttribute("kelompok", kelompokRepository.findAll());
        model.addAttribute("add", memberGroup);
        return "divpendidikan/add-groupmember";
    }
    @PostMapping("/savem")
    public String saveM(@ModelAttribute("add")MemberDivPendidikan memberDivPendidikan){
        System.out.println(memberDivPendidikan);
        memberDivPendidikanRepository.save(memberDivPendidikan);
        return "redirect:/divisi/pendidikan/add-member/";
    }
    @PostMapping("/saveg")
    public String saveG(Kelompok kelompok){
        kelompokRepository.save(kelompok);
        return "redirect:/divisi/pendidikan/add-group/";
    }
    @PostMapping("/savemg")
    public String saveM(MemberGroup memberGroup){
        memberGroupRepository.save(memberGroup);
        return "redirect:/divisi/pendidikan/add-groupmember/";
    }
    @GetMapping("/delete-g/{id}")
    public String deleteGroup(@PathVariable(value = "id")Long id,Model model){
        kelompokRepository.deleteById(id);
        return "redirect:/divisi/pendidikan/list-group/";
    }
    @GetMapping("/delete-m/{id}")
    public String deleteMember(@PathVariable(value = "id")Long id,Model model){
        memberDivPendidikanRepository.deleteById(id);
        return "redirect:/divisi/pendidikan/list/";
    }
    @GetMapping("/delete-mg/{id}")
    public String deleteMemberGroup(@PathVariable(value = "id")Long id,Model model){
        memberGroupRepository.deleteById(id);
        return "redirect:/divisi/pendidikan/list-membergroup/";
    }
    @GetMapping("/update-g/{id}")
    public String updateGroup(@PathVariable(value = "id")Long id,Model model){
        model.addAttribute("update", kelompokRepository.getReferenceById(id));
        return "divpendidikan/update-group";
    }
    @GetMapping("/update-m/{id}")
    public String updateMember(@PathVariable(value = "id")Long id,Model model){
        model.addAttribute("update", memberDivPendidikanRepository.getReferenceById(id));
        return "divpendidikan/update-member";
    }
    @GetMapping("/update-mg/{id}")
    public String updateMemberGroup(@PathVariable(value = "id")Long id,Model model){
        model.addAttribute("update", memberGroupRepository.getReferenceById(id));
        return "divpendidikan/update-membergroup";
    }
}