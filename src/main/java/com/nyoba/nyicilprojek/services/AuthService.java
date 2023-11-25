package com.nyoba.nyicilprojek.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.nyoba.nyicilprojek.models.Auth;
import com.nyoba.nyicilprojek.models.Member;
import com.nyoba.nyicilprojek.repository.AuthRepository;

@Service
public class AuthService{
    @Autowired
    private AuthRepository authRepository;
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
            List<Auth> all=userRepository.findAll();
            for (Auth user:all) {
                if (username.equalsIgnoreCase(user.getUsername())&&password.equalsIgnoreCase(user.getPassword())) {
                    isUserLogin=true; break;
            }}}
            if (isUserLogin) model.addAttribute("error","");
            else model.addAttribute("error","Account Not Found!");
            return "redirect:/login";
        }}
    public String add(Model model) {
        Auth auth = new Auth();
        model.addAttribute("add", auth);
        return "/auth/add";
    }
    public String save(Auth a) {
        // boolean isThere = false;
        // if (!userRepository.findAll().isEmpty()){
        //     List<Auth> auths = userRepository.findAll();
        // for (Auth auth : auths) {
        //     if (auth.getUsername().equals(a.getUsername())) {
        //         isThere = true;
        //         break;
        //     }
        // }}
        // if (isThere) {
        //     model.addAttribute("errormessage", "Data Telah Ada, Masukan Data Lain");
        //     return "redirect:/error";
        // } else {
            authRepository.save(a);
            return "redirect:/auth/add";
        // }
    }
}
