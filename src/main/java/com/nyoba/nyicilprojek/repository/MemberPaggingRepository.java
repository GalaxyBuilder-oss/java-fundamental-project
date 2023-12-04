package com.nyoba.nyicilprojek.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.nyoba.nyicilprojek.models.Member;

@Repository
public interface MemberPaggingRepository extends PagingAndSortingRepository<Member, Long> {
    
}
