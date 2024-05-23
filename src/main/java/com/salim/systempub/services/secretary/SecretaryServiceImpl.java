package com.salim.systempub.services.secretary;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.salim.systempub.config.ServiceConfig;
import com.salim.systempub.entities.Secretary;

@Service
public class SecretaryServiceImpl extends ServiceConfig implements SecretaryService {

    @Override
    public String home(Model model) {
        model.addAttribute("agenda", secretaryRepository.findAll());
        model.addAttribute("add", new Secretary());
        return "secretary/index";
    }

    @Override
    public String add(Model model) {
        Secretary agenda=new Secretary();
        model.addAttribute("add", agenda);
        return "secretary/add-agenda";
    }

    @Override
    public String save(Secretary agenda) {
        secretaryRepository.save(agenda);
        return "redirect:/sekretaris/";
    }

    @Override
    public String delete(Long id, Model model) {
        secretaryRepository.deleteById(id);
        return "redirect:/sekretaris/";
    }

    @Override
    public String agendaList(Model model) {
        model.addAttribute("agenda", secretaryRepository.findAll());
        return "secretary/list-agenda";
    }

}