package com.nyoba.nyicilprojek.repository.divitionrepository.divkerohanian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nyoba.nyicilprojek.models.divkerohanian.MemberDivKerohanian;

@Repository
public interface MemberDivkerohanianRepository extends JpaRepository<MemberDivKerohanian,Long> {
    
}
