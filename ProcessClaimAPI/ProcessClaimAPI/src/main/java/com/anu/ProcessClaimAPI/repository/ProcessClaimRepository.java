package com.anu.ProcessClaimAPI.repository;

import com.anu.ProcessClaimAPI.model.ClaimResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessClaimRepository extends JpaRepository<ClaimResponse, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM claimdetails cd where cd.customer_id=:customer_id")
    ClaimResponse findByCustomerId(@Param("customer_id") int customer_id);
}