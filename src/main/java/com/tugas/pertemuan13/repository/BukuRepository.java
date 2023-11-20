package com.tugas.pertemuan13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tugas.pertemuan13.models.Buku;

public interface BukuRepository extends JpaRepository<Buku, Long> {
    
}
