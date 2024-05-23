package com.salim.systempub.services.admin;

import org.springframework.ui.Model;
import com.salim.systempub.config.ServiceConfig;
import com.salim.systempub.constant.RolesConstant;
import com.salim.systempub.dto.AuthRequestDto;
import com.salim.systempub.entities.Auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl extends ServiceConfig implements AuthService {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String add(Model model) {
        model.addAttribute("member", memberRepository.findAll());
        model.addAttribute("add", new AuthRequestDto());
        model.addAttribute("roles", RolesConstant.DIVISI_LIST);
        return "admin/add-auth";
    }

    public String save(AuthRequestDto a, Model model) {
        try {
            Auth auth = new Auth();
            Long idMember = Long.valueOf(a.getIdMember());
            auth.setPassword(passwordEncoder.encode(a.getPassword()));
            auth.setIdMember(memberRepository.getReferenceById(idMember));
            auth.setRole(a.getRole().toUpperCase());
            if (authRepository.findByUsername(a.getUsername()).isPresent()) {
                auth.setUsername(a.getUsername());
                authRepository.save(auth);
            } else {
                throw new IllegalArgumentException("Username already exists");
            }
            return "redirect:/admin/";
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public String update(Long id, Model model) {
        Auth auth = authRepository.getReferenceById(id);
        auth.setPassword("");
        model.addAttribute("update", auth);
        return "admin/update-auth";
    }

    @Override
    public String saveUpdate(Auth auth, Model model) {
        try {
            String oldPass = auth.getPassword();
            String oldPassHashed = authRepository.getReferenceById(auth.getId()).getPassword();
            if (oldPass == null || oldPass.isEmpty()) {
                throw new IllegalArgumentException("Password cannot be empty");
            }
            if (!passwordEncoder.matches(oldPass, oldPassHashed)) {
                throw new IllegalArgumentException("Password is incorrect");
            }
            auth.setPassword(passwordEncoder.encode(oldPass));
            authRepository.save(auth);
            return "redirect:/admin/";
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public String delete(Long id) {
        authRepository.deleteById(id);
        return "redirect:/admin/";
    }
}
