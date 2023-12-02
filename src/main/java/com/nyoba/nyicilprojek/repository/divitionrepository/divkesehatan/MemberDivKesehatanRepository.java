package com.nyoba.nyicilprojek.repository.divitionrepository.divkesehatan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nyoba.nyicilprojek.models.divkesehatan.MemberDivKesehatan;

@Repository
public interface MemberDivKesehatanRepository extends JpaRepository<MemberDivKesehatan,Long> {
    
}
