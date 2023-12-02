package com.nyoba.nyicilprojek.models.divkerohanian;

import com.nyoba.nyicilprojek.models.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class MemberDivKerohanian {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_memberkerohanian",referencedColumnName = "id")
    private Member idMember;
    private String role;
}
