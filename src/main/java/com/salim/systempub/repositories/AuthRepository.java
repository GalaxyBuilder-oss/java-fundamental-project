package com.salim.systempub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salim.systempub.entities.Auth;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {

    @Query("select a from Auth a where a.idMember.id = :id")
    List<Auth> findByIdMemberId(Long id);
    
    Optional<Auth> findByUsername(String username);
}
