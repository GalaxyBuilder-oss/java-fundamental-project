package com.nyoba.nyicilprojek.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.domain.Sort;

import com.nyoba.nyicilprojek.config.AuthConfig;
import com.nyoba.nyicilprojek.models.Generation;
import com.nyoba.nyicilprojek.models.Member;
import com.nyoba.nyicilprojek.models.Auth;
import com.nyoba.nyicilprojek.services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController extends AuthConfig {

     @Autowired
     private AdminService adminService;

     @GetMapping("/")
     public String home(Model model) {
          model.addAttribute("genlist",genRepository.findAll());
          model.addAttribute("pubs",memberRepository.findAll(Sort.by(Sort.Direction.ASC, "name")));
          model.addAttribute("countPUB",memberRepository.count());
          model.addAttribute("totalAccount",authRepository.count());
          model.addAttribute("accounts",authRepository.findAll());
          return "admin/index";
     }
     @GetMapping("/add/")
     public String addAuth(Model model) {
          return authService.add(model);
     }
     @PostMapping("/save")
     public String saveAuth(Auth user,Model model) {
          return authService.save(user,model);
     }
     @GetMapping("/update/{id}")
     public String updateAuth(@PathVariable("id")Long id,Model model){
          model.addAttribute("update",authRepository.getReferenceById(id));
          return "admin/update-auth";
     }
     @PostMapping("/save-update")
     public String saveUpdateAuth(Auth auth){
          authRepository.save(auth);
          return "redirect:/admin/";
     }
     @GetMapping("/delete/{id}")
     public String deleteAuth(@PathVariable("id")Long id){
          authRepository.deleteById(id);
          return "redirect:/admin/";
     }

     //     Member PUB

     @GetMapping("/add-member/")
     public String add(Model model) {
          return adminService.addMember(model);
     }

     @PostMapping("/save-member")
     public String save(Member member, Model model) {
          return adminService.saveMember(member, model);
     }

     @GetMapping("/delete-member/{id}")
     public String delete(@PathVariable(value = "id") Long id, Model model) {
          return adminService.deleteMember(id, model);
     }

     @GetMapping("/update-member/{id}")
     public String update(@PathVariable(name = "id") Long id, Model model) {
          return adminService.updateMember(id, model);
     }

     @PostMapping("/saveupdate-member")
     public String saveUpdaString(Member member) {
          return adminService.saveUpdateMember(member);
     }

     //     Angkatan PUB

     @GetMapping("/add-gen/")
     public String addGen(Model model) {
          return adminService.addGen(model);
     }

     @PostMapping("/save-gen")
     public String saveGen(Generation gen, Model model) {
          return adminService.saveGen(gen, model);
     }

     @GetMapping("/delete-gen/{id}")
     public String deleteGen(@PathVariable(value = "id") Long id, Model model) {
          return adminService.deleteGen(id, model);
     }

     @GetMapping("/update-gen/{id}")
     public String updateGen(@PathVariable(name = "id") Long id, Model model) {
          return adminService.updateGen(id, model);
     }

     @PostMapping("/saveupdate-gen")
     public String saveUpdaString(Generation gen) {
          return adminService.saveUpdateGen(gen);
     }
}