package com.nyoba.nyicilprojek.repository.divitionrepository.divkesehatan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nyoba.nyicilprojek.models.divkesehatan.Farmacy;

@Repository
public interface FarmacyRepository extends JpaRepository<Farmacy,Long> {
    
}
