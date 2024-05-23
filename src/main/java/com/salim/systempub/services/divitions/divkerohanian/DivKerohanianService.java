package com.salim.systempub.services.divitions.divkerohanian;

import org.springframework.ui.Model;

import com.salim.systempub.dto.MemberRequestDto;
import com.salim.systempub.dto.divkerohanian.DataPUBRequestDto;

public interface DivKerohanianService {

    String home(Model model);

    String list(Model model);

    String addMember(Model model);

    String saveMember(MemberRequestDto dto);

    String deleteMember(Long id, Model model);

    String update(Long id, Model model);

    // Data PUB
    String listData(Model model);

    String addData(Model model);

    String saveData(DataPUBRequestDto dto);

    String updateData(Long id, Model model);

    String deleteData(Long id, Model model);
}
