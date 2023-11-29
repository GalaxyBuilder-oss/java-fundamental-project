package com.nyoba.nyicilprojek.models.divkesejahteraan;

import java.util.HashSet;
import java.util.Set;

import com.nyoba.nyicilprojek.models.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class MemberDivKesejahteraan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    @JoinColumn(name = "id_memberkesejahteraan",referencedColumnName = "id")
    private Set<Member> idMemberKesejahteraan=new HashSet<>();
    private String role;
}
