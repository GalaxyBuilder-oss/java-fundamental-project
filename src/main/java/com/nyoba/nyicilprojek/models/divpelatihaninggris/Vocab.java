package com.nyoba.nyicilprojek.models.divpelatihaninggris;

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
public class Vocab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_memberpelatihaninggris",referencedColumnName = "id")
    private Member id_member;
    private String vocab;
}
