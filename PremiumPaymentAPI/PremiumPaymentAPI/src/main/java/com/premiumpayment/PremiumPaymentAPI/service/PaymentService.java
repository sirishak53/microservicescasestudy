package com.premiumpayment.PremiumPaymentAPI.service;

import com.premiumpayment.PremiumPaymentAPI.model.PaymentRequest;

public interface PaymentService {
    public PaymentRequest processPayment(PaymentRequest paymentRequest);
}
