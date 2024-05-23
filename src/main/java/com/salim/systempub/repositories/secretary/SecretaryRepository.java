package com.salim.systempub.repositories.secretary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salim.systempub.entities.Secretary;

@Repository
public interface SecretaryRepository extends JpaRepository<Secretary,Long> {
    
}
