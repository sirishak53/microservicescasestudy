package com.anu.ProcessClaimAPI.service;

import com.anu.ProcessClaimAPI.model.ClaimResponse;

public interface ProcessClaimService {
    ClaimResponse getClaimDetails(int customer_id);
}
