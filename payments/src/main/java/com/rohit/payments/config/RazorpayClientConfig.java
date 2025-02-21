package com.rohit.payments.config;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorpayClientConfig {

    @Value("${payment.gateway.razorpay.key.id}")
    private String razrorpaykeyId;
    @Value("${payment.gateway.razorpay.key.secret}")
    private String razorpaysecret;

    @Bean
    public RazorpayClient getRazorpayClient() throws RazorpayException {
        return new RazorpayClient(razrorpaykeyId, razorpaysecret);
    }


   

}
