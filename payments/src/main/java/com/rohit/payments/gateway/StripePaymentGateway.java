package com.rohit.payments.gateway;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StripePaymentGateway implements PaymentGateway{

    @Override
    public String generatePaymentLink(Long amount, String orderId, String email, String phoneNumber) {
        return "";
    }
}
