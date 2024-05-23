package com.salim.systempub.services.ppmb;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.salim.systempub.config.ServiceConfig;
import com.salim.systempub.entities.PPMB;

@Service
public class PPMBServiceImpl extends ServiceConfig implements PPMBService {

    @Override
    public String home(Model model) {
        model.addAttribute("data", ppmbRepository.findAll());
        model.addAttribute("member", memberRepository.findAll(Sort.by(Sort.Direction.ASC, "name")));
        model.addAttribute("add", new PPMB());
        return "ppmb/index";
    }

    @Override
    public String save(PPMB ppmb) {
        ppmbRepository.save(ppmb);
        return "redirect:/ppmb/";
    }

    @Override
    public String delete(Long id, Model model) {
        ppmbRepository.deleteById(id);
        return "redirect:/ppmb/";
    }

}
