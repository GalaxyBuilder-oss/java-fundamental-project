package com.nyoba.nyicilprojek.models.divdik;

import java.util.UUID;

import com.nyoba.nyicilprojek.models.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class MemberDivition {
    private UUID id;
    @OneToMany
    @JoinColumn(name = "id_member",referencedColumnName = "id")
    private Member idMember;
    private String role;
}