package com.premiumpayment.PremiumPaymentAPI.repository;

import com.premiumpayment.PremiumPaymentAPI.model.PaymentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentRequest, Long> {
}
