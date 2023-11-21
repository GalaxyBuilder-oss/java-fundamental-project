package com.nyoba.nyicilprojek.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nyoba.nyicilprojek.models.Member;

public interface MemberRepository extends JpaRepository<Member, UUID> {
    
}
