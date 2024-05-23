package com.salim.systempub.entities.divpelatihaninggris;

import com.salim.systempub.entities.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class MemberDivPelatihanInggris {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_memberdivpelatihaninggris",referencedColumnName = "id")
    private Member idMember;
    private String role;
}
