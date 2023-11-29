package com.nyoba.nyicilprojek.models;

import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
@Entity
public class PPMB {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tpa_area;
    @OneToMany
    @JoinColumn(name="id_memberppmb",referencedColumnName = "id")
    private Set<Member> idMemberPPMB=new HashSet<>();
}
