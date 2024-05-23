package com.salim.systempub.repositories.divitionrepository.divkesejahteraan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salim.systempub.entities.divkesejahteraan.MemberDivKesejahteraan;

@Repository
public interface MemberDivKesejahteraanRepository extends JpaRepository<MemberDivKesejahteraan,Long> {

    @Query("SELECT m FROM MemberDivKesejahteraan m WHERE m.idMember.id = :id")
    List<MemberDivKesejahteraan> findByIdMemberId(Long id);
    
}
