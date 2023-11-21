package com.nyoba.nyicilprojek.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.nyoba.nyicilprojek.models.User;
import com.nyoba.nyicilprojek.repository.AuthRepository;

@Service
public class AuthService{
    @Autowired
    private static AuthRepository userRepository;
    private final static String ADMIN_USERNAME="admin";
    private final static String ADMIN_PASSWORD="admin123";
    public static boolean isAdminLogin=false;
    public static boolean isUserLogin=false;
    public static String authLogin(String username,String password,Model model) {
        if (username.equalsIgnoreCase(ADMIN_USERNAME) || password.equalsIgnoreCase(ADMIN_PASSWORD)) {
            isAdminLogin=true;
            return "redirect:/";
        } else {
            if(!userRepository.findAll().isEmpty()) {
            List<User> all=userRepository.findAll();
            for (User user:all) {
                if (username.equalsIgnoreCase(user.getUsername())&&password.equalsIgnoreCase(user.getPassword())) {
                    isUserLogin=true; break;
            }}}
            if (isUserLogin) model.addAttribute("error","");
            else model.addAttribute("error","Account Not Found!");
            return "redirect:/login";
        }}
}
