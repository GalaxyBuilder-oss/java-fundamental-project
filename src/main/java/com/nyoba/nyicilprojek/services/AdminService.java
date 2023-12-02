package com.nyoba.nyicilprojek.services;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.nyoba.nyicilprojek.models.Generation;
import com.nyoba.nyicilprojek.models.Member;
import com.nyoba.nyicilprojek.config.AuthConfig;
import com.nyoba.nyicilprojek.config.ServiceConfig;

@Service
public class AdminService extends ServiceConfig {

    public String showAllMember(Model model) {
        if (!memberRepository.findAll().isEmpty()) {
            model.addAttribute("isLogin", AuthConfig.isAdminLogin);
            model.addAttribute("all", memberRepository.findAll(Sort.by(Sort.Direction.ASC, "name")));
            model.addAttribute("count",memberRepository.count());
            return "admin/list-member";
        } else {
            model.addAttribute("allNull", null);
            return "redirect:/admin/add-member/";
        }
    }

    public String addMember(Model model) {
        Member member = new Member();
        model.addAttribute("isLogin", AuthConfig.isAdminLogin);
        model.addAttribute("add", member);
        return "admin/add-member";
    }

    public String saveMember(Member m, Model model) {
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
            return "error";
        } else {
            memberRepository.save(m);
            return "redirect:/admin/add-member/";
        }
    }

    public String deleteMember(Long id, Model model) {
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
            return "redirect:/admin/list-member/";
        } else {
            model.addAttribute("errormessage", "Data Tidak Ada, Masukan Data Lain");
            return "error";
        }
    }

    public String updateMember(Long id, Model model) {
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
            return "admin/update-member";
        } else {
            model.addAttribute("errormessage", "Data Tidak Ada, Masukan Data Lain");
            System.out.println("Error Mas");
            return "error";
        }
    }

    public String saveUpdateMember(Member member) {
        memberRepository.save(member);
        return "redirect:/admin/list-member/";
    }

//  Angkatan PUB
    public String showAllGen(Model model) {
        if (!generationRepository.findAll().isEmpty()) {
            model.addAttribute("all", generationRepository.findAll());
            return "admin/list-gen";
        } else {
            model.addAttribute("allNull", null);
            return "redirect:/admin/add-gen/";
        }
    }

    public String addGen(Model model) {
        Generation gen = new Generation();
        model.addAttribute("add", gen);
        return "admin/add-gen";
    }

    public String saveGen(Generation g, Model model) {
        generationRepository.save(g);
        return "redirect:/admin/add-gen/";
    }

    public String deleteGen(Long id, Model model) {
        List<Generation> gens = generationRepository.findAll();
        boolean isThere = false;
        for (Generation g : gens) {
            if (id.equals(g.getId())) {
                isThere = true;
                break;
            }
        }
        if (isThere) {
            generationRepository.deleteById(id);
            return "redirect:/admin/list-gen/";
        } else {
            model.addAttribute("errormessage", "Data Tidak Ada, Masukan Data Lain");
            return "error";
        }
    }

    public String updateGen(Long id, Model model) {
        List<Generation> gens = generationRepository.findAll();
        Generation gen = generationRepository.getReferenceById(id);
        boolean isThere = false;
        for (Generation g:gens) {
            if (g.getId().equals(id)) {
                isThere = true;
                break;
            }
        }
        if (isThere) {
            model.addAttribute("update", gen);
            return "admin/update-gen";
        } else {
            model.addAttribute("errormessage", "Data Tidak Ada, Masukan Data Lain");
            return "error";
        }
    }

    public String saveUpdateGen(Generation gen) {
        generationRepository.save(gen);
        return "redirect:/admin/list-gen/";
    }
}
