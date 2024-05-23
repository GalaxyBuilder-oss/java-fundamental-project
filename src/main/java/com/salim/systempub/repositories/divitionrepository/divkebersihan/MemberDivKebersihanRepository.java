package com.salim.systempub.repositories.divitionrepository.divkebersihan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salim.systempub.entities.divkebersihan.MemberDivKebersihan;

@Repository
public interface MemberDivKebersihanRepository extends JpaRepository<MemberDivKebersihan,Long> {

    @Query("select m from MemberDivKebersihan m where m.idMember.id = :id")
    List<MemberDivKebersihan> findByIdMemberId(Long id);
    
}
