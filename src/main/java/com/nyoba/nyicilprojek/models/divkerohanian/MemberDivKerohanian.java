package com.nyoba.nyicilprojek.models.divkerohanian;

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
public class MemberDivKerohanian {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    @JoinColumn(name = "id_memberkerohanian",referencedColumnName = "id")
    private Set<Member> idMemberKerohanian=new HashSet<>();
    private String role;
}
