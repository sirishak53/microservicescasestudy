package com.anu.ProcessClaimAPI.serviceimpl;

import com.anu.ProcessClaimAPI.controller.ProcessClaimController;
import com.anu.ProcessClaimAPI.model.ClaimResponse;
import com.anu.ProcessClaimAPI.repository.ProcessClaimRepository;
import com.anu.ProcessClaimAPI.service.ProcessClaimService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessClaimServiceImpl implements ProcessClaimService {

    @Autowired
    private ProcessClaimRepository processClaimRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProcessClaimController.class);

    @Override
    public ClaimResponse getClaimDetails(int customer_id) {
        ClaimResponse claimResponse = new ClaimResponse();
        try {
            claimResponse = processClaimRepository.findByCustomerId(customer_id);
            System.out.println("repo: " +claimResponse);
        } catch (Exception e) {
            claimResponse.setClaim_status("An unexpected error occurred during the process. Please try later");

        }
        return claimResponse;
    }
}
