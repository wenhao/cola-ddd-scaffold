package com.github.wenhao.order.gatewayimpl.remote;

import com.github.wenhao.gateway.PaymentGateway;
import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayImpl implements PaymentGateway {
    @Override
    public void pay(Long id, String payType) {
        return;
    }
}
