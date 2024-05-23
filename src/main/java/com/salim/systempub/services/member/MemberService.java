package com.salim.systempub.services.member;

import org.springframework.ui.Model;

import com.salim.systempub.entities.Member;

public interface MemberService {
    
    public String add(Model model);
    public String save(Member member, Model model);
    public String delete(Long id, Model model);
    public String update(Long id, Model model);
    public String saveUpdate(Member member);
    public String find(String nama, Model model);
}
