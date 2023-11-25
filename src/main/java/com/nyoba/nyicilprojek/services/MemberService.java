package com.nyoba.nyicilprojek.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.nyoba.nyicilprojek.models.Member;
import com.nyoba.nyicilprojek.repository.MemberRepository;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public String showAll(Model model) {
        if (!memberRepository.findAll().isEmpty()) {
            model.addAttribute("isLogin", AuthService.isAdminLogin);
            model.addAttribute("all", memberRepository.findAll(Sort.by(Sort.Direction.ASC, "name")));
            model.addAttribute("count",memberRepository.count());
            return "index";
        } else {
            model.addAttribute("allNull", null);
            return "redirect:/add";
        }
    }

    public String add(Model model) {
        Member member = new Member();
        model.addAttribute("isLogin", AuthService.isAdminLogin);
        model.addAttribute("add", member);
        return "add";
    }

    public String save(Member m, Model model) {
        boolean isThere = false;
        if (!memberRepository.findAll().isEmpty()){
            List<Member> members = memberRepository.findAll();
        for (Member member : members) {
            if (member.getNim().equals(m.getNim())) {
                isThere = true;
                break;
            }
        }}
        if (isThere) {
            model.addAttribute("errormessage", "Data Telah Ada, Masukan Data Lain");
            return "redirect:/error";
        } else {
            memberRepository.save(m);
            return "redirect:/add";
        }
    }

    public String delete(UUID id, Model model) {
        List<Member> members = memberRepository.findAll();
        boolean isThere = false;
        for (Member m : members) {
            if (id == m.getId()) {
                isThere = true;
                break;
            }
        }
        if (isThere) {
            memberRepository.deleteById(id);
            return "redirect:/";
        } else {
            model.addAttribute("errormessage", "Data Tidak Ada, Masukan Data Lain");
            return "redirect:/error";
        }
    }

    public String update(UUID id, Model model) {
        List<Member> members = memberRepository.findAll();
        Member member = memberRepository.getReferenceById(id);
        // Member member =  new Member();
        boolean isThere = false;
        for (Member m:members) {
            if (m.getId().equals(id)) {
                isThere = true;
                break;
            }
        }
        if (isThere) {
            model.addAttribute("isLogin", AuthService.isAdminLogin);
            model.addAttribute("update", member);
            return "update";
        } else {
            model.addAttribute("errormessage", "Data Tidak Ada, Masukan Data Lain");
            System.out.println("Error Mas");
            return "redirect:/error";
        }
    }

    public String saveUpdate(Member member) {
        try {
            memberRepository.save(member);
            
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return "redirect:/";
    }
    public String find(String nama, Model model) {
        // List<Member> members = memberRepository.findAll();
        // List<Member> m = new ArrayList<>();
        // for (Member member : members) {
        //     if (member.getName().contains(nama)) {
        //         m.add(member);
        //     }
        // }
        model.addAttribute("isLogin", AuthService.isAdminLogin);
        model.addAttribute("all", memberRepository.findByNameContainingIgnoreCase(nama,Sort.by(Sort.Direction.ASC, "name")));
        return "find";
    }
}
