package com.salim.systempub.repositories.divitionrepository.divpendidikan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salim.systempub.entities.divpendidikan.MemberGroup;

@Repository
public interface MemberGroupRepository extends JpaRepository<MemberGroup, Long> {

    @Query("select m from MemberGroup m where m.idMember.id = :id")
    List<MemberGroup> findByIdMemberId(Long id);
    
}
