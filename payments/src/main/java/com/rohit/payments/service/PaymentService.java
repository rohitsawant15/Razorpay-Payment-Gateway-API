package com.rohit.payments.service;

import com.rohit.payments.gateway.PaymentGateway;
import com.rohit.payments.gateway.PaymentGatewayStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentGatewayStrategy paymentGatewayStrategy;


    public String initiatePayment(String orderId, String email, String phoneNumber, Long amount){
       PaymentGateway bestpaymentGateway =  paymentGatewayStrategy.getBestPaymentGetway();
       return bestpaymentGateway.generatePaymentLink(amount,orderId,email,phoneNumber);
    }
}
