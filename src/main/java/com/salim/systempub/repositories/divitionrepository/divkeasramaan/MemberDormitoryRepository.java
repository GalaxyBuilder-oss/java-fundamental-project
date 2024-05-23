package com.salim.systempub.repositories.divitionrepository.divkeasramaan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salim.systempub.entities.divkeasramaan.MemberDormitory;

@Repository
public interface MemberDormitoryRepository extends JpaRepository<MemberDormitory,Long> {

    @Query("select m from MemberDormitory m where m.idMember.id = :id")
    List<MemberDormitory> findByIdMemberId(Long id);
    
}
