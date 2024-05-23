package com.salim.systempub.services.chamberlain;

import org.springframework.ui.Model;

import com.salim.systempub.entities.chamberlain.Chamberlain;

public interface ChamberlainService {
    
    String home(Model model);
    String expenseIncomeList(Model model);
    String add(Model model);
    String delete(Long id,Model model);
    String deleteBalance(Long id, Model model);
    String save(Chamberlain chamberlain);
}
