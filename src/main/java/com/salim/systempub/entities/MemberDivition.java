package com.salim.systempub.entities;

import com.salim.systempub.entities.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class MemberDivition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String divitionName;
    @ManyToOne
    @JoinColumn(name = "id_memberdivition",referencedColumnName = "id")
    private Member idMember;
    private String role;
}
