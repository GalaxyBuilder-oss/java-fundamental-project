package com.salim.systempub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salim.systempub.entities.Generation;

@Repository
public interface GenerationRepository extends JpaRepository<Generation,Long> {

}
