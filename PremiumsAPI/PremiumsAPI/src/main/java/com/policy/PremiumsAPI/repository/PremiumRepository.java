package com.policy.PremiumsAPI.repository;

import com.policy.PremiumsAPI.model.GetPremiumResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiumRepository extends JpaRepository<GetPremiumResponse, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM policydetails pd where pd.policy_number=:policy_number")
    GetPremiumResponse findByPolicyNumber(@Param("policy_number") String policy_number);
}
