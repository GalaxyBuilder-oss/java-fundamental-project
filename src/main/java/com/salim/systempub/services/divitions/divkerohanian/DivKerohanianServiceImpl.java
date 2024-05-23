package com.salim.systempub.services.divitions.divkerohanian;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.salim.systempub.config.ServiceConfig;
import com.salim.systempub.dto.MemberRequestDto;
import com.salim.systempub.dto.divkerohanian.DataPUBRequestDto;
import com.salim.systempub.entities.divkerohanian.DataPUB;
import com.salim.systempub.entities.divkerohanian.MemberDivKerohanian;

@Service
public class DivKerohanianServiceImpl extends ServiceConfig implements DivKerohanianService {

    @Override
    public String home(Model model) {

        model.addAttribute("memberDiv", memberDivkerohanianRepository.findAll());
        model.addAttribute("addMember", new MemberRequestDto());
        model.addAttribute("addReligion", new DataPUBRequestDto());
        model.addAttribute("member", memberRepository.findAll());
        model.addAttribute("data", dataPUBRepository.findAll());
        return "divkerohanian/index";
    }

    @Override
    public String list(Model model) {
        return "divkerohanian/list";
    }

    @Override
    public String addMember(Model model) {
        model.addAttribute("add", new MemberRequestDto());
        model.addAttribute("member", memberRepository.findAll());
        return "divkerohanian/add";
    }

    @Override
    public String saveMember(MemberRequestDto dto) {

        MemberDivKerohanian member = new MemberDivKerohanian();
        member.setIdMember(memberRepository.findById(Long.parseLong(dto.getIdMember())).orElse(null));
        member.setRole(dto.getRole());
        memberDivkerohanianRepository.save(member);
        return "redirect:/divisi/kerohanian/";
    }

    @Override
    public String deleteMember(Long id, Model model) {

        memberDivkerohanianRepository.deleteById(id);
        return "redirect:/divisi/kerohanian/";
    }

    @Override
    public String update(Long id, Model model) {
        model.addAttribute("member", memberRepository.findAll());
        model.addAttribute("update", memberDivkerohanianRepository.getReferenceById(id));
        return "divkerohanian/update";
    }

    @Override
    public String listData(Model model) {
        model.addAttribute("data", dataPUBRepository.findAll());
        return "divkerohanian/list-data";
    }

    @Override
    public String addData(Model model) {
        model.addAttribute("add", new DataPUBRequestDto());
        model.addAttribute("member", memberRepository.findAll());
        return "divkerohanian/add-data";
    }

    @Override
    public String saveData(DataPUBRequestDto dto) {
        DataPUB data = new DataPUB();
        data.setHafalan(dto.getHafalan());
        data.setIdMember(memberRepository.findById(Long.parseLong(dto.getIdMember())).orElse(null));
        data.setPointleft(dto.getPointleft());
        dataPUBRepository.save(data);
        return "redirect:/divisi/kerohanian/";
    }

    @Override
    public String updateData(Long id, Model model) {
        model.addAttribute("member", memberRepository.findAll());
        model.addAttribute("update", dataPUBRepository.getReferenceById(id));
        return "divkerohanian/update-data";
    }

    @Override
    public String deleteData(Long id, Model model) {
        dataPUBRepository.deleteById(id);
        return "redirect:/divisi/kerohanian/";
    }

}
