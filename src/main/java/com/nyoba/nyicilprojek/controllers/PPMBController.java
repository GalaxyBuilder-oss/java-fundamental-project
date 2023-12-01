package com.nyoba.nyicilprojek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nyoba.nyicilprojek.models.PPMB;
import com.nyoba.nyicilprojek.repository.MemberRepository;
import com.nyoba.nyicilprojek.repository.ppmb.PPMBRepository;

@Controller
@RequestMapping("/ppmb")
public class PPMBController {

    @Autowired
    private PPMBRepository ppmbRepository;
    @Autowired
    private MemberRepository memberRepository;
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("isLogin",true);
        return "ppmb/index";
    }
    @GetMapping("/list")
    public String agendaList(Model model){
        model.addAttribute("data", ppmbRepository.findAll());
        return "ppmb/list";
    }
    @GetMapping("/add/")
    public String add(Model model){
        PPMB ppmb=new PPMB();
        model.addAttribute("member", memberRepository.findAll(Sort.by(Sort.Direction.ASC, "name")));
        model.addAttribute("add", ppmb);
        return "ppmb/add";
    }
    @PostMapping("/post")
    public String save(PPMB ppmb){
        ppmbRepository.save(ppmb);
        return "redirect:/ppmb/add/";
    }
}