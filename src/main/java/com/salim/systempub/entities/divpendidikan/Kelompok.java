package com.salim.systempub.entities.divpendidikan;

import com.salim.systempub.entities.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Kelompok {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String practiceGroup;

    @ManyToOne
    @JoinColumn(name="id_instruktur",referencedColumnName="id")
    private Member idMember;
}
