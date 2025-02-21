package com.rohit.payments.controller;


import com.rohit.payments.dto.InitiatePaymentDto;
import com.rohit.payments.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/payment_links")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<String> initiatePayment(@RequestBody InitiatePaymentDto initiatePaymentDto){
        String paymentLink = paymentService.initiatePayment(initiatePaymentDto.getOrderId(),
                initiatePaymentDto.getEmail(), initiatePaymentDto.getPhoneNumber(),
                initiatePaymentDto.getAmount());
        return new ResponseEntity<>(paymentLink, HttpStatus.CREATED);
    }
    
    /**
     * 
     * http://localhost:8807/v1/payment_links
     * {
    "email":"sawantrohit8676@gmail.com",
    "orderId" : "87689877",
    "phoneNumber" :"7887650302",
    "amount":100
}
     */
}
