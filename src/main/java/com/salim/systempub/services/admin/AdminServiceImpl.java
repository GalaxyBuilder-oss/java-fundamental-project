package com.salim.systempub.services.admin;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.salim.systempub.config.ServiceConfig;
import com.salim.systempub.constant.AuthConstantHelper;
import com.salim.systempub.entities.Generation;

@Service
public class AdminServiceImpl extends ServiceConfig implements AdminService {

//  Angkatan PUB
    public String addGen(Model model) {
        Generation gen = new Generation();
        model.addAttribute("add", gen);
        return "admin/add-gen";
    }

    public String saveGen(Generation g, Model model) {
        if (g == null) {
            throw new IllegalArgumentException("Generation object cannot be null");
        }

        try {
            generationRepository.save(g);
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while saving the generation");
            return "error";
        }

        return "redirect:/admin/";
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
            return "redirect:/admin/";
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
        return "redirect:/admin/";
    }

    @Override
    public String home(Model model) {

        model.addAttribute("genlist", generationRepository.findAll());
          model.addAttribute("pubs", memberRepository.findAll(Sort.by(Sort.Direction.ASC, "name")));
          model.addAttribute("countPUB", memberRepository.count());
          model.addAttribute("totalAccount", authRepository.count());
          model.addAttribute("accounts", authRepository.findAll());
          if (!AuthConstantHelper.messageAdmin.equals("")) {
               model.addAttribute("ifMessage", true);
               model.addAttribute("name", AuthConstantHelper.contact);
               model.addAttribute("number", AuthConstantHelper.number);
               model.addAttribute("message", AuthConstantHelper.messageAdmin);
          }
          return "admin/index";
    }
}
