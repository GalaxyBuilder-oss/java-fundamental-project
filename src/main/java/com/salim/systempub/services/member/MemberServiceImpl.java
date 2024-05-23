package com.salim.systempub.services.member;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.salim.systempub.config.ServiceConfig;
import com.salim.systempub.entities.Member;

@Service
public class MemberServiceImpl extends ServiceConfig implements MemberService {

    public String add(Model model) {
        Member member = new Member();
        model.addAttribute("add", member);
        model.addAttribute("generation", generationRepository.findAll());
        return "/admin/add-member";
    }

    public String save(Member m, Model model) {

        if (memberRepository.findAll().isEmpty() || memberRepository.findAll().stream()
                .filter(data -> data.getNim().equals(m.getNim())).findAny().isEmpty()) {
            memberRepository.save(m);
            return "redirect:/admin/";
        } else {

            model.addAttribute("error", "Data Telah Ada, Masukan Data Lain");
            return "error";
        }
    }

    public String delete(Long id, Model model) {

        authRepository.findByIdMemberId(id).stream().forEach(authRepository::delete);

        memberDivKeasramaanRepository.findByIdMemberId(id).stream().forEach(memberDivKeasramaanRepository::delete);

        memberDivKebersihanRepository.findByIdMemberId(id).stream().forEach(memberDivKebersihanRepository::delete);

        memberDivKesehatanRepository.findByIdMemberId(id).stream().forEach(memberDivKesehatanRepository::delete);

        memberDivKesejahteraanRepository.findByIdMemberId(id).stream()
                .forEach(memberDivKesejahteraanRepository::delete);

        memberDivPelatihanInggrisRepository.findByIdMemberId(id).stream()
                .forEach(memberDivPelatihanInggrisRepository::delete);

        memberDivPendidikanRepository.findByIdMemberId(id).stream().forEach(memberDivPendidikanRepository::delete);

        memberDivkerohanianRepository.findByIdMemberId(id).stream().forEach(memberDivkerohanianRepository::delete);

        memberDormitoryRepository.findByIdMemberId(id).stream().forEach(memberDormitoryRepository::delete);

        kelompokRepository.findByIdMemberId(id).stream().forEach(kelompokRepository::delete);

        memberGroupRepository.findByIdMemberId(id).stream().forEach(memberGroupRepository::delete);

        dataPUBRepository.findByIdMemberId(id).stream().forEach(dataPUBRepository::delete);

        piketRepository.findByIdMemberId(id).stream().forEach(piketRepository::delete);

        ppmbRepository.findByIdMemberId(id).stream().forEach(ppmbRepository::delete);

        vocabRepository.findByIdMemberId(id).stream().forEach(vocabRepository::delete);

        Member member = memberRepository.findById(id).orElse(null);

        if (member.equals(null)) {
            model.addAttribute("error", "Data Tidak Ada, Masukan Data Lain");
            return "redirect:/error";
        }

        memberRepository.deleteById(id);
        return "redirect:/admin/";
    }

    public String update(Long id, Model model) {
        try {
            Member member = memberRepository.findById(id).orElse(null);
            if (member != null)
                model.addAttribute("update", member);
            return "/admin/";
        } catch (Exception e) {
            System.out.println("Error Mas");
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public String saveUpdate(Member member) {
        try {
            memberRepository.save(member);

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new IllegalArgumentException(e.getMessage());
        }
        return "redirect:/admin/";
    }

    public String find(String nama, Model model) {
        model.addAttribute("all",
                memberRepository.findByNameContainingIgnoreCase(nama, Sort.by(Sort.Direction.ASC, "name")));
        return "find";
    }
}
