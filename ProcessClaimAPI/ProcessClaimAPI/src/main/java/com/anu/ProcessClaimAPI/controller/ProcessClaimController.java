package com.anu.ProcessClaimAPI.controller;

import com.anu.ProcessClaimAPI.model.ClaimResponse;
import com.anu.ProcessClaimAPI.service.ProcessClaimService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProcessClaimController {

    @Autowired
    ProcessClaimService processClaimService;

    private static final Logger logger = LoggerFactory.getLogger(ProcessClaimController.class);

    ClaimResponse claimResponse = null;

    /**
     * This method is invoked when customer want to see the premium details
     *
     * @param customer_id
     * @return ResponseEntity<GetPremiumResponse>
     */
    @GetMapping("/getClaimDetails/{customer_id}")
    public ResponseEntity<ClaimResponse> getClaimDetails(@PathVariable(value = "customer_id") int customer_id) {

        if (customer_id != 0) {
            claimResponse = getClaims(customer_id);
            return new ResponseEntity<ClaimResponse>(claimResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<ClaimResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ClaimResponse getClaims(int customerId) {

        try {
            claimResponse = processClaimService.getClaimDetails(customerId);

        } catch (Exception e) {
            logger.warn("unable to get the premium details: {}", e);
        }
        return claimResponse;
    }
}
