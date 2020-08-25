package com.policy.PremiumsAPI.serviceimpl;

import com.policy.PremiumsAPI.model.GetPremiumResponse;
import com.policy.PremiumsAPI.repository.PremiumRepository;
import com.policy.PremiumsAPI.service.PremiumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PremiumServiceImpl implements PremiumService {

    @Autowired
    private PremiumRepository premiumRepository;

    private static final Logger logger = LoggerFactory.getLogger(PremiumServiceImpl.class);

    @Override
    public GetPremiumResponse getPremiumDetails(String customerId) {
        GetPremiumResponse getPremiumResponse = null;
        try {
            getPremiumResponse = premiumRepository.findByPolicyNumber(customerId);
        } catch (Exception e) {
            logger.warn("unable to fetch premiums: {}", e);
        }
        return getPremiumResponse;
    }
}
