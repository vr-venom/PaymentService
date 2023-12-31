package com.scaler.paymentservice.paymentgateway;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentGateway {
    String generatePaymentLink(Long amount, String orderId) throws StripeException, RazorpayException;
}
