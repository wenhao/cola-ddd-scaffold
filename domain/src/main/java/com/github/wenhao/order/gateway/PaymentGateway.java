package com.github.wenhao.order.gateway;

public interface PaymentGateway {
    void pay(Long id, String payType);
}
