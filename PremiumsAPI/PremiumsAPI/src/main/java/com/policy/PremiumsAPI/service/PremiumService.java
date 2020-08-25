package com.policy.PremiumsAPI.service;

import com.policy.PremiumsAPI.model.GetPremiumResponse;

public interface PremiumService {
    public GetPremiumResponse getPremiumDetails(String customerId);
}
