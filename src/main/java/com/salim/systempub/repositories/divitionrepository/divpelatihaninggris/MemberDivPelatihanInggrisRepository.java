package com.salim.systempub.repositories.divitionrepository.divpelatihaninggris;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salim.systempub.entities.divpelatihaninggris.MemberDivPelatihanInggris;

@Repository
public interface MemberDivPelatihanInggrisRepository extends JpaRepository<MemberDivPelatihanInggris,Long> {

    @Query("select m from MemberDivPelatihanInggris m where m.idMember.id = :id")
    List<MemberDivPelatihanInggris> findByIdMemberId(Long id);
    
}
