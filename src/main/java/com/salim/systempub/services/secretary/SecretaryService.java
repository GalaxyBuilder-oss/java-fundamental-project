package com.salim.systempub.services.secretary;

import org.springframework.ui.Model;

import com.salim.systempub.entities.Secretary;

public interface SecretaryService {
    
    String agendaList(Model model);
    String home(Model model);
    String add(Model model);
    String save(Secretary agenda);
    String delete(Long id, Model model);
}
