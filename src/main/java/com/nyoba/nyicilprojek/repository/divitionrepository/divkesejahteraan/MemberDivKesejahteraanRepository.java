package com.nyoba.nyicilprojek.repository.divitionrepository.divkesejahteraan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nyoba.nyicilprojek.models.divkesejahteraan.MemberDivKesejahteraan;

@Repository
public interface MemberDivKesejahteraanRepository extends JpaRepository<MemberDivKesejahteraan,Long> {
    
}
