package com.salim.systempub.services.admin;

import org.springframework.ui.Model;

import com.salim.systempub.dto.AuthRequestDto;
import com.salim.systempub.entities.Auth;

public interface AuthService {
    
    public String add(Model model);
    public String save(AuthRequestDto dto, Model model);
    public String update(Long id, Model model);
    public String saveUpdate(Auth auth, Model model);
    public String delete(Long id);
}
