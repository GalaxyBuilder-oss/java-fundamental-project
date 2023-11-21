package com.nyoba.nyicilprojek.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nyoba.nyicilprojek.models.Auth;

public interface AuthRepository extends JpaRepository<Auth, UUID> {
    
}
