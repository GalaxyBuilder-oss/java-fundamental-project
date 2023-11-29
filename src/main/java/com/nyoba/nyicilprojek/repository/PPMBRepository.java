package com.nyoba.nyicilprojek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nyoba.nyicilprojek.models.PPMB;

@Repository
public interface PPMBRepository extends JpaRepository<PPMB,Long> {

}