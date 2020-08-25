package com.premiumpayment.PremiumPaymentAPI.controller;

import com.premiumpayment.PremiumPaymentAPI.model.PaymentRequest;
import com.premiumpayment.PremiumPaymentAPI.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    /**
     * This method is invoked when customer clicks on payment button.
     * @param paymentRequest
     * @return paymentRequest1
     */
    @PostMapping(value = "/makePayment")
    public ResponseEntity<PaymentRequest> makePayment(@RequestBody PaymentRequest paymentRequest) {
        PaymentRequest paymentRequest1 = null;
        if (paymentRequest != null) {
            try {
                paymentRequest1 = processPayment(paymentRequest);
            } catch (Exception e){
                logger.warn("request not valid", e);
            }
        }
        return new ResponseEntity<PaymentRequest>(paymentRequest1, HttpStatus.OK);
    }

    private PaymentRequest processPayment(PaymentRequest paymentRequest) {
        return paymentService.processPayment(paymentRequest);
    }
}

