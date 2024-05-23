package com.salim.systempub.repositories.divitionrepository.divkesehatan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salim.systempub.entities.divkesehatan.Farmacy;

@Repository
public interface FarmacyRepository extends JpaRepository<Farmacy,Long> {
    
}
