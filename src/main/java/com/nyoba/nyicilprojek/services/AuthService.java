package com.nyoba.nyicilprojek.services;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nyoba.nyicilprojek.models.Auth;
import com.nyoba.nyicilprojek.config.ServiceConfig;

@Service
public class AuthService extends ServiceConfig{

    public String add(Model model) {
        Auth auth = new Auth();
        model.addAttribute("add", auth);
        return "admin/add-auth";
    }
    public String save(Auth a, Model model) {
        boolean isThere = false;
        if (!authRepository.findAll().isEmpty()){
            List<Auth> auths = authRepository.findAll();
        for (Auth auth : auths) {
            if (auth.getUsername().equals(a.getUsername())) {
                isThere = true;
                break;
            }
        }}
        if (isThere) {
            model.addAttribute("errormessage", "Data Telah Ada, Masukan Data Lain");
            return "error";
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            Auth auth = new Auth();
            auth.setId(a.getId());
            auth.setUsername(a.getUsername());
            auth.setPassword(passwordEncoder.encode(a.getPassword()));
            auth.setRole(a.getRole().toUpperCase());
            authRepository.save(auth);
            return "redirect:/admin/";
        }
    }
}
