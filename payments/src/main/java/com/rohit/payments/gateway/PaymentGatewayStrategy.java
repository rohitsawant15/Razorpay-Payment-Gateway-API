package com.rohit.payments.gateway;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PaymentGatewayStrategy {

    private final RazorpayPaymentGateway razorpayPaymentGateway;
    private final StripePaymentGateway stripePaymentGateway;

   

    public PaymentGateway getBestPaymentGetway(){
        int value = (int) Math.random();
        int remainder = value%2;
        /**
        switch (remainder){
            case 0 :
                return this.razorpayPaymentGateway;
            case 1 :
                return this.stripePaymentGateway;
        }
         **/
        return this.razorpayPaymentGateway;
    }
}
