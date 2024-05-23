package com.salim.systempub.repositories.divitionrepository.divpendidikan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salim.systempub.entities.divpendidikan.Kelompok;

@Repository
public interface KelompokRepository extends JpaRepository<Kelompok, Long> {

    @Query("select k from Kelompok k where k.idMember.id = :id")
    List<Kelompok> findByIdMemberId(Long id);

}
