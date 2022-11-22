package com.github.wenhao.gateway;

public interface PaymentGateway {
    void pay(Long id, String payType);
}
