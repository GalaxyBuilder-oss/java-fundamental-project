package com.nyoba.nyicilprojek.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nyoba.nyicilprojek.models.Auth;

@Repository
public interface AuthRepository extends JpaRepository<Auth, UUID> {
    Auth findByUsername(String username);
}
