package com.nyoba.nyicilprojek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nyoba.nyicilprojek.models.Generation;

@Repository
public interface GenerationRepository extends JpaRepository<Generation,Long> {

}
