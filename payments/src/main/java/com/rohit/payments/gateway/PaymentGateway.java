package com.rohit.payments.gateway;

public interface PaymentGateway {

    String generatePaymentLink(Long amount, String orderId, String email, String phoneNumber);

}
