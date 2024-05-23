package com.salim.systempub.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.salim.systempub.config.ServiceConfig;
import com.salim.systempub.constant.AuthConstantHelper;
import com.salim.systempub.constant.ConstHelper;
import com.salim.systempub.constant.RolesConstant;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class MainServiceImpl extends ServiceConfig implements MainService {

    @Override
    public String home(Model model) {

        model.addAttribute("isAdmin", ConstHelper.userRole.equals(RolesConstant.ADMIN));
        return "index";
    }

    @Override
    public String divitionList() {
        return "list-divisi";
    }

    @Override
    public String Login() {
        return "login";
    }

    @Override
    public String customLogout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login";
    }

    @Override
    public String customDenied(HttpServletRequest request, HttpServletResponse response) {
        return "page-error";
    }

    @Override
    public String callAdmin(Model model) {
        model.addAttribute("response", false);
        return "calladmin";
    }

    @Override
    public String aboutPage() {
        return "about";
    }

    @Override
    public String sendToAdmin(String name, String number, String message, Model model) {
        AuthConstantHelper.contact = name;
        AuthConstantHelper.number = number;
        AuthConstantHelper.messageAdmin = message;
        model.addAttribute("response", "Pesan Terkirim, Tunggu Infomasi Lebih Lanjut Lewat Data Yang Anda Kirim");
        return "calladmin";
    }

}
