package com.premiumpayment.PremiumPaymentAPI.serviceimpl;

import com.premiumpayment.PremiumPaymentAPI.model.PaymentRequest;
import com.premiumpayment.PremiumPaymentAPI.repository.PaymentRepository;
import com.premiumpayment.PremiumPaymentAPI.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Override
    public PaymentRequest processPayment(PaymentRequest paymentRequest) {

        PaymentRequest paymentRequest1 = null;
        try {

            paymentRequest1 = paymentRepository.save(new PaymentRequest(paymentRequest.getCustomer_id(), paymentRequest.getTransaction_amount(), paymentRequest.getTransaction_date()));

            if (paymentRequest1.getTransactionId() != 0) {

                System.out.println(paymentRequest1.toString());

                paymentRequest1.setTransaction_status("transaction completed");

            }
        } catch (Exception e) {
            paymentRequest1.setTransaction_status("transaction pending");
        }
        return paymentRequest1;

    }
}
