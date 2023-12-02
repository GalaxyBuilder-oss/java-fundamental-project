package com.nyoba.nyicilprojek.repository.divitionrepository.divkebersihan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nyoba.nyicilprojek.models.divkebersihan.Piket;

@Repository
public interface PiketRepository extends JpaRepository<Piket,Long> {
    
}
