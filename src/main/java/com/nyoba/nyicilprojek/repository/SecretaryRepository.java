package com.nyoba.nyicilprojek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nyoba.nyicilprojek.models.Secretary;

@Repository
public interface SecretaryRepository extends JpaRepository<Secretary,Long> {
    
}
