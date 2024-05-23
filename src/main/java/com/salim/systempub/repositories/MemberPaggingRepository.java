package com.salim.systempub.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.salim.systempub.entities.Member;

@Repository
public interface MemberPaggingRepository extends PagingAndSortingRepository<Member, Long> {
    
}
