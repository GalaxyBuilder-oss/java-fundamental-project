package com.salim.systempub.services;

import org.springframework.ui.Model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface MainService {
    
    String home(Model model);
    String divitionList();
    String Login();
    String customLogout(HttpServletRequest request, HttpServletResponse response);
    String customDenied(HttpServletRequest request, HttpServletResponse response);
    String callAdmin(Model model);
    String sendToAdmin(String name, String number, String message, Model model);
    String aboutPage();
}
