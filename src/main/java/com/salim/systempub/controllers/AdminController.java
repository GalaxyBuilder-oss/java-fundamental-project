package com.salim.systempub.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salim.systempub.dto.AuthRequestDto;
import com.salim.systempub.entities.Auth;
import com.salim.systempub.entities.Generation;
import com.salim.systempub.entities.Member;
import com.salim.systempub.services.admin.AdminService;
import com.salim.systempub.services.admin.AuthService;
import com.salim.systempub.services.member.MemberService;

import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/admin")
public class AdminController {

     @Autowired
     private AdminService adminService;

     @Autowired
     MemberService memberService;

     @Autowired
     AuthService authService;

     @GetMapping("/")
     public String home(Model model) {
          try {
               return adminService.home(model);
          } catch (Exception e) {
               e.printStackTrace();
               model.addAttribute("error", e.getMessage());
               return "error";
          }
     }

     @GetMapping("/add/")
     public String addAuth(Model model) {
          try {
               return authService.add(model);
          } catch (Exception e) {
               e.printStackTrace();
               model.addAttribute("error", e.getMessage());
               return "error";
          }
     }

     @PostMapping("/save")
     public String saveAuth(AuthRequestDto user, Model model) {
          try {
               return authService.save(user, model);
          } catch (Exception e) {
               e.printStackTrace();
               model.addAttribute("error", e.getMessage());
               return "error";
          }
     }

     @GetMapping("/update/{id}")
     public String updateAuth(@PathVariable("id") Long id, Model model) {
          try {
               return authService.update(id, model);
          } catch (Exception e) {
               e.printStackTrace();
               model.addAttribute("error", e.getMessage());
               return "error";
          }
     }

     @PostMapping("/save-update")
     public String saveUpdateAuth(@ModelAttribute("add") Auth auth, Model model) {
          try {
               return authService.saveUpdate(auth, model);
          } catch (Exception e) {
               e.printStackTrace();
               return "error";
          }
     }

     @GetMapping("/delete/{id}")
     public String deleteAuth(@PathVariable("id") Long id) {
          try {
               return authService.delete(id);
          } catch (Exception e) {
               e.printStackTrace();
               return "error";
          }
     }

     // Member PUB

     @GetMapping("/add-member/")
     public String add(Model model) {
          try {
               return memberService.add(model);
          } catch (Exception e) {
               e.printStackTrace();
               model.addAttribute("error", e.getMessage());
               return "error";
          }
     }

     @PostMapping("/save-member")
     public String save(Member member, Model model) {
          try {
               return memberService.save(member, model);
          } catch (Exception e) {
               e.printStackTrace();
               model.addAttribute("error", e.getMessage());
               return "error";
          }
     }

     @GetMapping("/delete-member/{id}")
     public String delete(@PathVariable(value = "id") Long id, Model model) {
          try {
               return memberService.delete(id, model);
          } catch (Exception e) {
               e.printStackTrace();
               model.addAttribute("error", e.getMessage());
               return "error";
          }
     }

     @GetMapping("/update-member/{id}")
     public String update(@PathVariable(name = "id") Long id, Model model) {
          try {
               return memberService.update(id, model);
          } catch (Exception e) {
               e.printStackTrace();
               model.addAttribute("error", e.getMessage());
               return "error";
          }
     }

     @PostMapping("/saveupdate-member")
     public String saveUpdaString(Member member) {
          try {
               return memberService.saveUpdate(member);
          } catch (Exception e) {
               e.printStackTrace();
               return "error";
          }
     }

     // Angkatan PUB

     @GetMapping("/add-gen/")
     public String addGen(Model model) {
          try {
               return adminService.addGen(model);
          } catch (Exception e) {
               e.printStackTrace();
               model.addAttribute("error", e.getMessage());
               return "error";
          }
     }

     @PostMapping("/save-gen")
     public String saveGen(Generation gen, Model model) {
          try {
               return adminService.saveGen(gen, model);
          } catch (Exception e) {
               e.printStackTrace();
               model.addAttribute("error", e.getMessage());
               return "error";
          }
     }

     @GetMapping("/delete-gen/{id}")
     public String deleteGen(@PathVariable(value = "id") Long id, Model model) {
          try {
               return adminService.deleteGen(id, model);
          } catch (Exception e) {
               e.printStackTrace();
               model.addAttribute("error", e.getMessage());
               return "error";
          }
     }

     @GetMapping("/update-gen/{id}")
     public String updateGen(@PathVariable(name = "id") Long id, Model model) {
          try {
               return adminService.updateGen(id, model);
          } catch (Exception e) {
               e.printStackTrace();
               model.addAttribute("error", e.getMessage());
               return "error";
          }
     }

     @PostMapping("/saveupdate-gen")
     public String saveUpdaString(Generation gen) {
          try {
               return adminService.saveUpdateGen(gen);
          } catch (Exception e) {
               e.printStackTrace();
               return "error";
          }
     }
}
