package com.github.wenhao.order.gateway.remote;

public interface PaymentGateway {
    void pay(Long id, String payType);
}
