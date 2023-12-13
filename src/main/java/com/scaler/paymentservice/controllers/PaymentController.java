package com.scaler.paymentservice.controllers;

import com.scaler.paymentservice.dtos.CreatePaymentLinkDto;
import com.scaler.paymentservice.services.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }
    @PostMapping("/")
    public String creatPaymentLink(@RequestBody CreatePaymentLinkDto request) throws StripeException {
        return paymentService.createPaymentLink(request.getOrderId());
    }
}
