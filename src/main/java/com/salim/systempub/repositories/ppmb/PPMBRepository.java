package com.salim.systempub.repositories.ppmb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salim.systempub.entities.PPMB;

@Repository
public interface PPMBRepository extends JpaRepository<PPMB,Long> {

    @Query("select p from PPMB p where p.idMember.id = :id")
    List<PPMB> findByIdMemberId(Long id);

}