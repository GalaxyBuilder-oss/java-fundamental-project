package com.nyoba.nyicilprojek.controllers.divkesejahteraan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nyoba.nyicilprojek.models.divkesejahteraan.Food;
import com.nyoba.nyicilprojek.models.divkesejahteraan.MemberDivKesejahteraan;
import com.nyoba.nyicilprojek.repository.MemberRepository;
import com.nyoba.nyicilprojek.repository.divitionrepository.divkesejahteraan.FoodRepository;
import com.nyoba.nyicilprojek.repository.divitionrepository.divkesejahteraan.MemberDivKesejahteraanRepository;

@Controller
@RequestMapping("/divisi/kesejahteraan")
public class DivKesejahteraanController {
    @Autowired
    private MemberDivKesejahteraanRepository memberDivKesejahteraanRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/")
    public String home(){
        return "divkesejahteraan/index";
    }
    @GetMapping("/list/")
    public String list(Model model){
        model.addAttribute("member", memberDivKesejahteraanRepository.findAll());
        return "divkesejahteraan/list";
    }
    @GetMapping("/add/")
    public String addMember(Model model){
        MemberDivKesejahteraan member=new MemberDivKesejahteraan();
        model.addAttribute("add", member);
        model.addAttribute("member", memberRepository.findAll());
        return "divkesejahteraan/add";
    }
    @PostMapping("/save")
    public String saveMember(MemberDivKesejahteraan member){
        memberDivKesejahteraanRepository.save(member);
        return "redirect:/divisi/kesejahteraan/add/";
    }
    @GetMapping("/delete/{id}")
    public String deleteString(@PathVariable(value = "id")Long id,Model model){
        memberDivKesejahteraanRepository.deleteById(id);
        return "redirect:/divisi/kesejahteraan/list/";
    }
    @GetMapping("/update/{id}")
    public String updateString(@PathVariable(value = "id")Long id,Model model){
        model.addAttribute("update", memberDivKesejahteraanRepository.getReferenceById(id));
        return "divkesejahteraan/update";
    }

    // Launch And Breakfast
    @GetMapping("/list-menu/")
    public String foodMenu(Model model){
        model.addAttribute("menu", foodRepository.findAll());
        return "divkesejahteraan/list-menu";
    }
    @GetMapping("/add-menu/")
    public String addFood(Model model){
        Food foodMenu=new Food();
        model.addAttribute("add", foodMenu);
        return "divkesejahteraan/add-menu";
    }
    @PostMapping("/save-menu")
    public String saveFood(Food food){
        foodRepository.save(food);
        return "redirect:/divisi/kesejahteraan/add-menu/";
    }
    @GetMapping("/delete-menu/{id}")
    public String deleteFood(@PathVariable(value = "id")Long id,Model model){
        foodRepository.deleteById(id);
        return "redirect:/divisi/kesejahteraan/list-menu/";
    }
    @GetMapping("/update-menu/{id}")
    public String updateFood(@PathVariable(value = "id")Long id,Model model){
        model.addAttribute("update",foodRepository.getReferenceById(id));
        return "divkesejahteraan/update-menu";
    }
}
