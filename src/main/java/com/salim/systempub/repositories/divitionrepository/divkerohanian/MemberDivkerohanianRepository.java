package com.salim.systempub.repositories.divitionrepository.divkerohanian;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salim.systempub.entities.divkerohanian.MemberDivKerohanian;

@Repository
public interface MemberDivkerohanianRepository extends JpaRepository<MemberDivKerohanian,Long> {

    @Query("select m from MemberDivKerohanian m where m.idMember.id = :id")
    List<MemberDivKerohanian> findByIdMemberId(Long id);
    
}
