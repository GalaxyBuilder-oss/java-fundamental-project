package com.nyoba.nyicilprojek.repository.chamberlain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nyoba.nyicilprojek.models.chamberlain.PUBBalance;

@Repository
public interface PUBBalanceRepository extends JpaRepository<PUBBalance,Long> {

}
