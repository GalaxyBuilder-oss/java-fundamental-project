package com.salim.systempub.services.user;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.salim.systempub.config.ServiceConfig;
import com.salim.systempub.constant.AuthConstantHelper;
import com.salim.systempub.entities.Member;
import com.salim.systempub.entities.PPMB;
import com.salim.systempub.entities.divkeasramaan.MemberDivKeasramaan;
import com.salim.systempub.entities.divkeasramaan.MemberDormitory;
import com.salim.systempub.entities.divkebersihan.MemberDivKebersihan;
import com.salim.systempub.entities.divkebersihan.Piket;
import com.salim.systempub.entities.divkerohanian.DataPUB;
import com.salim.systempub.entities.divkerohanian.MemberDivKerohanian;
import com.salim.systempub.entities.divkesehatan.MemberDivKesehatan;
import com.salim.systempub.entities.divkesejahteraan.MemberDivKesejahteraan;
import com.salim.systempub.entities.divpelatihaninggris.MemberDivPelatihanInggris;
import com.salim.systempub.entities.divpelatihaninggris.Vocab;
import com.salim.systempub.entities.divpendidikan.MemberDivPendidikan;

@Service
public class UserServiceImpl extends ServiceConfig implements UserService {

    @Override
    public String home(Model model) {
        Member member = authRepository.findByUsername(AuthConstantHelper.username)
                .orElse(null).getIdMember();

        if (member == null)
            return "redirect:/";

        model.addAttribute("member", member);

        PPMB ppmb = ppmbRepository.findByIdMemberId(member.getId()).stream()
                .findFirst().orElse(null);

        if (ppmb != null) {
            model.addAttribute("datappmb", ppmb.getTpaArea());
        }

        DataPUB dataPUB = dataPUBRepository.findByIdMemberId(member.getId()).stream().findFirst().orElse(null);

        if (dataPUB != null) {
            model.addAttribute("poin", dataPUB.getPointleft());
            model.addAttribute("hafalan", dataPUB.getHafalan());
        }

        Piket piket = piketRepository.findByIdMemberId(member.getId()).stream()
                .findFirst().orElse(null);

        if (piket != null) {
            model.addAttribute("piketday", piket.getDay());
            model.addAttribute("piketroom", piket.getIdroom().getRoom());
        }

        Vocab vocab = vocabRepository.findByIdMemberId(member.getId()).stream()
                .findFirst().orElse(null);

        if (vocab != null) {
            model.addAttribute("vocab", vocab.getVocab());
        }

        MemberDormitory memberDormitory = memberDormitoryRepository.findByIdMemberId(member.getId()).stream()
                .findFirst().orElse(null);

        if (memberDormitory != null) {
            model.addAttribute("dataasrama", memberDormitory.getDorm());
        }

        MemberDivKeasramaan memberDivKeasramaan = memberDivKeasramaanRepository.findByIdMemberId(member.getId())
                .stream().findFirst().orElse(null);

        if (memberDivKeasramaan != null) {
            model.addAttribute("datadivkeasramaan", memberDivKeasramaan.getRole());
        }

        MemberDivKebersihan memberDivKebersihan = memberDivKebersihanRepository.findByIdMemberId(member.getId())
                .stream().findFirst().orElse(null);

        if (memberDivKebersihan != null) {
            model.addAttribute("datadivkebersihan", memberDivKebersihan.getRole());
        }

        MemberDivKerohanian memberDivKerohanian = memberDivkerohanianRepository.findByIdMemberId(member.getId())
                .stream().findFirst().orElse(null);

        if (memberDivKerohanian != null) {
            model.addAttribute("datadivkerohanian", memberDivKerohanian.getRole());
        }

        MemberDivKesehatan memberDivKesehatan = memberDivKesehatanRepository.findByIdMemberId(member.getId()).stream()
                .findFirst().orElse(null);

        if (memberDivKesehatan != null) {
            model.addAttribute("datadivkesehatan", memberDivKesehatan.getRole());
        }

        MemberDivPelatihanInggris memberDivPelatihanInggris = memberDivPelatihanInggrisRepository
                .findByIdMemberId(member.getId()).stream().findFirst().orElse(null);

        if (memberDivPelatihanInggris != null) {
            model.addAttribute("datadivpelatihaninggris", memberDivPelatihanInggris.getRole());
        }

        MemberDivPendidikan memberDivPendidikan = memberDivPendidikanRepository
                .findByIdMemberId(member.getId()).stream().findFirst().orElse(null);

        if (memberDivPendidikan != null) {
            model.addAttribute("datadivpendidikan", memberDivPendidikan.getRole());
        }

        MemberDivKesejahteraan memberDivKesejahteraan = memberDivKesejahteraanRepository
                .findByIdMemberId(member.getId()).stream().findFirst().orElse(null);

        if (memberDivKesejahteraan != null) {
            model.addAttribute("datadivkesejahteraan", memberDivKesejahteraan.getRole());
        }

        return "user/index";
    }

}
