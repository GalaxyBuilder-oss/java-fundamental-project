package com.salim.systempub.repositories.divitionrepository.divpelatihaninggris;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salim.systempub.entities.divpelatihaninggris.Vocab;

@Repository
public interface VocabRepository extends JpaRepository<Vocab,Long> {

    @Query("select v from Vocab v where v.idMember.id = :id")
    List<Vocab> findByIdMemberId(Long id);
    
}
