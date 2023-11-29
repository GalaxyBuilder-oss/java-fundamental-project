package com.nyoba.nyicilprojek.models.divpendidikan;

import java.util.HashSet;
import java.util.Set;

import com.nyoba.nyicilprojek.models.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class MemberGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int value;
    @OneToMany
    @JoinColumn(name = "id_memberpendidikanpelatihan", referencedColumnName = "id")
    private Set<Member> idMemberPendidikanPelatihan=new HashSet<>();
    @Column(columnDefinition = "TEXT")
    private String description;
    @OneToMany
    @JoinColumn(name = "id_grouppendidikanpelatihan", referencedColumnName = "id")
    private Set<Kelompok> idGroupPendidikanPelatihan=new HashSet<>();
}
