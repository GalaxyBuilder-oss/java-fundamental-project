package com.salim.systempub.repositories.divitionrepository.divkerohanian;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salim.systempub.entities.divkerohanian.DataPUB;

@Repository
public interface DataPUBRepository extends JpaRepository<DataPUB,Long> {

    @Query("select d from DataPUB d where d.idMember.id = :id")
    List<DataPUB> findByIdMemberId(Long id);
    
}
