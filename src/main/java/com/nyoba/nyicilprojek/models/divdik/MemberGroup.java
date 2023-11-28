package com.nyoba.nyicilprojek.models.divdik;

import java.util.UUID;

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
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int value;
    @OneToMany
    @JoinColumn(name = "id_group", referencedColumnName = "id")
    private Group idGroup;
    @OneToMany
    @JoinColumn(name = "id_member", referencedColumnName = "id")
    private Member idMember;
    @Column(columnDefinition = "TEXT")
    private String description;
}
