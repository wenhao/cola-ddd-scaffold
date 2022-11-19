package com.github.wenhao.order.gatewayimpl;

import com.github.wenhao.order.gateway.PaymentGateway;
import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayImpl implements PaymentGateway {
    @Override
    public void pay(Long id, String payType) {
        return;
    }
}
