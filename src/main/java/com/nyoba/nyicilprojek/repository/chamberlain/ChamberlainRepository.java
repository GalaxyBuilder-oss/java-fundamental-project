package com.nyoba.nyicilprojek.repository.chamberlain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nyoba.nyicilprojek.models.chamberlain.Chamberlain;

@Repository
public interface ChamberlainRepository extends JpaRepository<Chamberlain,Long> {

}
