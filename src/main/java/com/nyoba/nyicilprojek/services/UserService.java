package com.nyoba.nyicilprojek.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.nyoba.nyicilprojek.models.User;
import com.nyoba.nyicilprojek.repository.UserRepository;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;
    private final String ADMIN_USERNAME="admin";
    private final String ADMIN_PASSWORD="admin123";
    public boolean isAdminLogin=false;
    public boolean isUserLogin=false;
    public String authLogin(String username,String password,Model model) {
        if (username.equalsIgnoreCase(ADMIN_USERNAME) && password.equalsIgnoreCase(ADMIN_PASSWORD)) {
            isAdminLogin=true;
            return "request:/admin";
        } else {
            List<User> all=userRepository.findAll();
            for (User user:all) {
                if (username.equalsIgnoreCase(user.getUsername())&&password.equalsIgnoreCase(user.getPassword())) {
                    isUserLogin=true; break;
            }}
            if (isUserLogin) model.addAttribute("error","");
            else model.addAttribute("error","Account Not Found!");
            return "redirect:/user";
    }}
    public String saveUser() {

        return "redirect:/login";
    }
}
