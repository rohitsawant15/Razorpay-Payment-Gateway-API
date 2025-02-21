package com.rohit.payments.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InitiatePaymentDto {
    private String email;
    private String orderId;
    private String phoneNumber;
    private Long amount;

}
