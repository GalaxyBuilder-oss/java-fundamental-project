package com.salim.systempub.services.ppmb;

import org.springframework.ui.Model;

import com.salim.systempub.entities.PPMB;

public interface PPMBService {

    String home(Model model);
    String save(PPMB ppmb);
    String delete(Long id, Model model);

}
