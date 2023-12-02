package com.nyoba.nyicilprojek.repository.divitionrepository.divpendidikan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nyoba.nyicilprojek.models.divpendidikan.Kelompok;

@Repository
public interface KelompokRepository extends JpaRepository<Kelompok, Long> {

}
