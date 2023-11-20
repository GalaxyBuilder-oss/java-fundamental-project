package com.nyoba.nyicilprojek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nyoba.nyicilprojek.models.Buku;

public interface BukuRepository extends JpaRepository<Buku, Long> {
    
}
