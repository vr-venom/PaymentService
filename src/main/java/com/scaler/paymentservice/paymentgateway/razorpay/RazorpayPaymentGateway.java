package com.scaler.paymentservice.paymentgateway.razorpay;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.scaler.paymentservice.paymentgateway.PaymentGateway;
import org.json.JSONObject;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class RazorpayPaymentGateway implements PaymentGateway {
    @Override
    public String generatePaymentLink(Long amount, String orderId) throws RazorpayException {
        RazorpayClient razorpay = new RazorpayClient("rzp_test_urtt2p449hzSKG", "iqSiVl7Wv2HJRimqqHfXLnWh");
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",amount);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("callback_url","https://example-callback-url.com/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
        return payment.toString();
    }

}
