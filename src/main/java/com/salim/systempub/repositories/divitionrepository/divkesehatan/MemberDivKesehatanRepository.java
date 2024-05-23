package com.salim.systempub.repositories.divitionrepository.divkesehatan;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salim.systempub.entities.divkesehatan.MemberDivKesehatan;

@Repository
public interface MemberDivKesehatanRepository extends JpaRepository<MemberDivKesehatan,Long> {

    @Query("select m from MemberDivKesehatan m where m.idMember.id = :id")
    List<MemberDivKesehatan> findByIdMemberId(Long id);
    
}
