package com.salim.systempub.repositories.chamberlain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salim.systempub.entities.chamberlain.Chamberlain;

@Repository
public interface ChamberlainRepository extends JpaRepository<Chamberlain,Long> {

}
