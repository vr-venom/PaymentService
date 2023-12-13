package com.scaler.paymentservice.services;

import com.scaler.paymentservice.dtos.CreatePaymentLinkDto;
import com.scaler.paymentservice.paymentgateway.stripe.StripePaymentGateway;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private StripePaymentGateway stripePaymentGateway;
    public PaymentService(StripePaymentGateway stripePaymentGateway) {
        this.stripePaymentGateway = stripePaymentGateway;
    }

    public String createPaymentLink(Long orderId) throws StripeException {

        return stripePaymentGateway.generatePaymentLink(1000L, orderId.toString());
    }
}
