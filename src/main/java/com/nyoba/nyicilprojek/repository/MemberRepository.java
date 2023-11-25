package com.nyoba.nyicilprojek.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nyoba.nyicilprojek.models.Member;

public interface MemberRepository extends JpaRepository<Member, UUID> {
    List<Member> findByNameContainingIgnoreCase(String nama,Sort sort);
}
