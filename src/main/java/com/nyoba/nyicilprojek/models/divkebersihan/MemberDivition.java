package com.nyoba.nyicilprojek.models.divkebersihan;

import java.util.UUID;

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
public class MemberDivition {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToMany
    @JoinColumn(name = "id_member",referencedColumnName = "id")
    private Member idMember;
    private String role;
}
