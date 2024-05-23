package com.salim.systempub.repositories.divitionrepository.divkeasramaan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salim.systempub.entities.divkeasramaan.MemberDivKeasramaan;

@Repository
public interface MemberDivKeasramaanRepository extends JpaRepository<MemberDivKeasramaan,Long> {

    @Query("select m from MemberDivKeasramaan m where m.idMember.id = :id")
    List<MemberDivKeasramaan> findByIdMemberId(Long id);
    
}
