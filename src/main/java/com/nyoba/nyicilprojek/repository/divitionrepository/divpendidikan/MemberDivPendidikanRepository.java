package com.nyoba.nyicilprojek.repository.divitionrepository.divpendidikan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nyoba.nyicilprojek.models.divpendidikan.MemberDivPendidikan;

@Repository
public interface MemberDivPendidikanRepository extends JpaRepository<MemberDivPendidikan,Long> {
    
}
