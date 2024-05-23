package com.salim.systempub.repositories.divitionrepository.divkebersihan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salim.systempub.entities.divkebersihan.Piket;

@Repository
public interface PiketRepository extends JpaRepository<Piket,Long> {

    @Query("select p from Piket p where p.idMember.id = :id")
    List<Piket> findByIdMemberId(Long id);
    
}
