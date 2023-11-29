package com.nyoba.nyicilprojek.models.divpelatihaninggris;

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
public class MemberDivPelatihanInggris {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    @JoinColumn(name = "id_memberpeltihaninggris",referencedColumnName = "id")
    private Set<Member> idMemberPelatihanInggris=new HashSet<>();
    private String role;
}
