package com.nyoba.nyicilprojek.services;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nyoba.nyicilprojek.models.Auth;
import com.nyoba.nyicilprojek.config.AuthConfig;
import com.nyoba.nyicilprojek.config.ServiceConfig;

@Service
public class AuthService extends ServiceConfig{

    public String authLogin(String username,String password,Model model) {
        if(!authRepository.findAll().isEmpty()) {
        List<Auth> all=authRepository.findAll();
        for (Auth user:all) {
            if (username.equalsIgnoreCase(user.getUsername())&&password.equalsIgnoreCase(user.getPassword())) {
                if(user.getRole().equalsIgnoreCase("admin")) AuthConfig.isAdminLogin=true;
                // else if(user.getRole().equalsIgnoreCase("bendahara")){AuthConfig.isAdminLogin=true;AuthConfig.role=user.getRole();}
                else AuthConfig.isUserLogin=true;
                AuthConfig.isLogin=true;
                break;
            }
        }
    }
    if(AuthConfig.isAdminLogin) {
        // if(AuthConfig.role.equalsIgnoreCase("bendahara"))return "redirect:/bendahara/";
        return "redirect:/admin/";
    } else if(AuthConfig.isUserLogin){
        AuthConfig.isLogin=true;
        return "redirect:/user/";
    } else model.addAttribute("errormessage","Account Not Found!");
    return "error";
    }
    public String add(Model model) {
        Auth auth = new Auth();
        model.addAttribute("add", auth);
        return "/auth/add";
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
            auth.setRole(a.getRole());
            authRepository.save(auth);
            return "redirect:/auth/add/";
        }
    }
}
