package com.nyoba.nyicilprojek.repository.divitionrepository.divkerohanian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nyoba.nyicilprojek.models.divkerohanian.DataPUB;

@Repository
public interface DataPUBRepository extends JpaRepository<DataPUB,Long> {
    
}
