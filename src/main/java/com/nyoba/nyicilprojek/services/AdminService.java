package com.nyoba.nyicilprojek.services;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.nyoba.nyicilprojek.models.Member;
import com.nyoba.nyicilprojek.config.AuthConfig;
import com.nyoba.nyicilprojek.config.ServiceConfig;

@Service
public class AdminService extends ServiceConfig {

    public String showAll(Model model) {
        if (!memberRepository.findAll().isEmpty()) {
            model.addAttribute("isLogin", AuthConfig.isAdminLogin);
            model.addAttribute("all", memberRepository.findAll(Sort.by(Sort.Direction.ASC, "name")));
            model.addAttribute("count",memberRepository.count());
            return "/admin/scholar-list";
        } else {
            model.addAttribute("allNull", null);
            return "redirect:/admin/add";
        }
    }

    public String add(Model model) {
        Member member = new Member();
        model.addAttribute("isLogin", AuthConfig.isAdminLogin);
        model.addAttribute("add", member);
        return "/admin/add";
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
            return "redirect:/admin/add";
        }
    }

    public String delete(Long id, Model model) {
        List<Member> members = memberRepository.findAll();
        boolean isThere = false;
        for (Member m : members) {
            if (id.equals(m.getId())) {
                isThere = true;
                break;
            }
        }
        if (isThere) {
            memberRepository.deleteById(id);
            return "redirect:/admin/scholar-list";
        } else {
            model.addAttribute("errormessage", "Data Tidak Ada, Masukan Data Lain");
            return "redirect:/error";
        }
    }

    public String update(Long id, Model model) {
        List<Member> members = memberRepository.findAll();
        Member member = memberRepository.getReferenceById(id);
        boolean isThere = false;
        for (Member m:members) {
            if (m.getId().equals(id)) {
                isThere = true;
                break;
            }
        }
        if (isThere) {
            model.addAttribute("isLogin", AuthConfig.isAdminLogin);
            model.addAttribute("update", member);
            return "/admin/update";
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
        return "redirect:/admin/scholar-list";
    }
}
