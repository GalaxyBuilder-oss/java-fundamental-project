package com.nyoba.nyicilprojek.repository.divitionrepository.divkeasramaan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nyoba.nyicilprojek.models.divkeasramaan.MemberDivKeasramaan;

@Repository
public interface MemberDivKeasramaanRepository extends JpaRepository<MemberDivKeasramaan,Long> {
    
}
