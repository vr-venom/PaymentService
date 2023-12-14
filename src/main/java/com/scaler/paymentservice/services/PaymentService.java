package com.scaler.paymentservice.services;

import com.razorpay.RazorpayException;
import com.scaler.paymentservice.paymentgateway.stripe.StripePaymentGateway;
import com.stripe.exception.StripeException;
import com.scaler.paymentservice.paymentgateway.razorpay.RazorpayPaymentGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService {
    private StripePaymentGateway stripePaymentGateway;
    private RazorpayPaymentGateway razorpayPaymentGateway;


    public String createPaymentLink(Long orderId) throws StripeException, RazorpayException {

        return razorpayPaymentGateway.generatePaymentLink(1000L, orderId.toString());
    }
}
