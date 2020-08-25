package com.policy.PremiumsAPI.controller;

import com.policy.PremiumsAPI.model.GetPremiumResponse;
import com.policy.PremiumsAPI.service.PremiumService;
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
public class RetrievePremiumsController {

    @Autowired
    private PremiumService premiumService;

    GetPremiumResponse getPremiumResponse = null;

    private static final Logger logger = LoggerFactory.getLogger(RetrievePremiumsController.class);

    /**
     * This method is invoked when customer want to see the premium details
     *
     * @param policy_number
     * @return ResponseEntity<GetPremiumResponse>
     */
    @GetMapping("/getPremiumDetails/{policy_number}")
    public ResponseEntity<GetPremiumResponse> getPremiumDetails(@PathVariable(value = "policy_number") String policy_number) {

        logger.info("controller start");
        if (policy_number != null) {
            getPremiumResponse = retrievePremiums(policy_number);
            logger.info("controller end");
            return new ResponseEntity<GetPremiumResponse>(getPremiumResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<GetPremiumResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private GetPremiumResponse retrievePremiums(String customerId) {

        try {
            getPremiumResponse = premiumService.getPremiumDetails(customerId);

        } catch (Exception e) {
            logger.warn("unable to get the premium details: {}", e);
        }
        return getPremiumResponse;
    }
}
