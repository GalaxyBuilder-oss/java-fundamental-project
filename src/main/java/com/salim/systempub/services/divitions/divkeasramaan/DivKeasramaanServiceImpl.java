package com.salim.systempub.services.divitions.divkeasramaan;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.salim.systempub.config.ServiceConfig;
import com.salim.systempub.dto.MemberRequestDto;
import com.salim.systempub.dto.divkeasramaan.BoarderRequestDto;
import com.salim.systempub.entities.divkeasramaan.MemberDivKeasramaan;
import com.salim.systempub.entities.divkeasramaan.MemberDormitory;

@Service
public class DivKeasramaanServiceImpl extends ServiceConfig implements DivKeasramaanService {

    @Override
    public String home(Model model) {
        model.addAttribute("addMember", new MemberRequestDto());
        model.addAttribute("memberDiv", memberDivKeasramaanRepository.findAll());
        model.addAttribute("member", memberRepository.findAll());
        model.addAttribute("dweller", memberDormitoryRepository.findAll());
        model.addAttribute("addDweller", new BoarderRequestDto());
        return "divkeasramaan/index";
    }

    @Override
    public String list(Model model) {
        model.addAttribute("memberDiv", memberDivKeasramaanRepository.findAll());
        return "divkeasramaan/list";
    }

    @Override
    public String add(Model model) {
        model.addAttribute("add", new MemberRequestDto());
        model.addAttribute("member", memberRepository.findAll());
        return "divkeasramaan/add";
    }

    @Override
    public String save(MemberRequestDto dto) {
        MemberDivKeasramaan member = new MemberDivKeasramaan();
        member.setIdMember(memberRepository.findById(Long.parseLong(dto.getIdMember())).orElse(null));
        member.setRole(dto.getRole());
        memberDivKeasramaanRepository.save(member);
        return "redirect:/divisi/keasramaan/";
    }

    @Override
    public String update(Long id, Model model) {
        model.addAttribute("member", memberRepository.findAll());
        model.addAttribute("update", memberDivKeasramaanRepository.getReferenceById(id));
        return "divkeasramaan/update";
    }

    @Override
    public String delete(Long id, Model model) {
        memberDivKeasramaanRepository.deleteById(id);
        return "redirect:/divisi/keasramaan/";
    }

    @Override
    public String addBoarder(Model model) {
        model.addAttribute("member", memberRepository.findAll());
        return "divkeasramaan/add-penghuni";
    }

    @Override
    public String saveBoarder(BoarderRequestDto dto) {
        MemberDormitory member = new MemberDormitory();
        member.setIdMember(memberRepository.findById(Long.parseLong(dto.getIdMember())).orElse(null));
        member.setDorm(dto.getDorm());
        member.setDescription(dto.getDescription());
        memberDormitoryRepository.save(member);
        return "redirect:/divisi/keasramaan/";
    }

    @Override
    public String deleteBoarder(Long id, Model mode) {
        memberDormitoryRepository.deleteById(id);
        return "redirect:/divisi/keasramaan/";
    }

    @Override
    public String updateBoarder(Long id, Model model) {
        model.addAttribute("member", memberRepository.findAll());
        model.addAttribute("update", memberDormitoryRepository.getReferenceById(id));
        return "divkeasramaan/update-penghuni";
    }

    @Override
    public String listBoarder(Model model) {
        return "divkeasramaan/list-penghuni";
    }

}
