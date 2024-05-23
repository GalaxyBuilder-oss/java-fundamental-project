package com.salim.systempub.services.divitions.divkeasramaan;

import org.springframework.ui.Model;

import com.salim.systempub.dto.MemberRequestDto;
import com.salim.systempub.dto.divkeasramaan.BoarderRequestDto;

public interface DivKeasramaanService {

    // Member Div Keasramaan
    String home(Model model);
    String list(Model model);
    String add(Model model);
    String save(MemberRequestDto dto);
    String update(Long id, Model model);
    String delete(Long id, Model model);

    // Anggota Asrama
    String listBoarder(Model model);
    String addBoarder(Model model);
    String saveBoarder(BoarderRequestDto dto);
    String deleteBoarder(Long id, Model mode);
    String updateBoarder(Long id, Model model);
    
}
