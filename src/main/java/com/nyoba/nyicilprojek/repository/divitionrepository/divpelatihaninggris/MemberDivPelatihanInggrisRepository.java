package com.nyoba.nyicilprojek.repository.divitionrepository.divpelatihaninggris;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nyoba.nyicilprojek.models.divpelatihaninggris.MemberDivPelatihanInggris;

@Repository
public interface MemberDivPelatihanInggrisRepository extends JpaRepository<MemberDivPelatihanInggris,Long> {
    
}
