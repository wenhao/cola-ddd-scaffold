package com.github.wenhao.order.gatewayimpl.remote;

import com.github.wenhao.order.model.Order;
import com.github.wenhao.gateway.NotificationGateway;
import org.springframework.stereotype.Component;

@Component
public class NotificationGatewayImpl implements NotificationGateway {
    @Override
    public void notify(Order order) {
        return;
    }
}
