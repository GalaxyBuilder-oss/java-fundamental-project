package com.salim.systempub.services.admin;

import org.springframework.ui.Model;

import com.salim.systempub.entities.Generation;

public interface AdminService {

    // Admin Homepage
    public String home(Model model);

    // Crud Generation
    public String addGen(Model model);
    public String saveGen(Generation generation, Model model);
    public String deleteGen(Long id, Model model);
    public String updateGen(Long id, Model model);
    public String saveUpdateGen(Generation generation);
}
