package com.nyoba.nyicilprojek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nyoba.nyicilprojek.models.Auth;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {
    Auth findByUsername(String username);
}
