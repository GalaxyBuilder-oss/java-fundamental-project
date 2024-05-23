package com.salim.systempub.repositories.divitionrepository.divpendidikan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salim.systempub.entities.divpendidikan.MemberDivPendidikan;

@Repository
public interface MemberDivPendidikanRepository extends JpaRepository<MemberDivPendidikan,Long> {

    @Query("select m from MemberDivPendidikan m where m.idMember.id = :id")
    List<MemberDivPendidikan> findByIdMemberId(Long id);
    
}
