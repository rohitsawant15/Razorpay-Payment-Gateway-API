package com.rohit.payments.gateway;

import com.razorpay.PaymentLink;
import java.time.Instant;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RazorpayPaymentGateway implements PaymentGateway{

    private final RazorpayClient razorpayClient;

    @Override
    public String generatePaymentLink(Long amount, String orderId, String email, String phoneNumber) {
        try{
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount",amount);
            paymentLinkRequest.put("currency","INR");
            paymentLinkRequest.put("accept_partial",false);
            paymentLinkRequest.put("first_min_partial_amount",100);
            
            

            long expireBy = Instant.now().getEpochSecond() + 1800; // At least 15 minutes in the future
            paymentLinkRequest.put("expire_by", expireBy);

 
            paymentLinkRequest.put("reference_id",orderId);
            paymentLinkRequest.put("description","Payment for policy no #"+orderId);
            
            JSONObject customer = new JSONObject();
            customer.put("name","Rohit");
            customer.put("contact", phoneNumber);
            customer.put("email",email);
            paymentLinkRequest.put("customer",customer);
            JSONObject notify = new JSONObject();
            notify.put("sms",true);
            notify.put("email",true);
            paymentLinkRequest.put("notify",notify);
            paymentLinkRequest.put("reminder_enable",true);
//            JSONObject notes = new JSONObject();
//            notes.put("policy_name","Test Policy");
//            paymentLinkRequest.put("notes",notes);
            paymentLinkRequest.put("callback_url","https://www.geeksforgeeks.org/java/");
            paymentLinkRequest.put("callback_method","get");

            PaymentLink paymentLink = razorpayClient.paymentLink.create(paymentLinkRequest);
            return paymentLink.get("short_url").toString();
        }catch(RazorpayException ex){
            throw new RuntimeException(ex);
        }
    }
}
