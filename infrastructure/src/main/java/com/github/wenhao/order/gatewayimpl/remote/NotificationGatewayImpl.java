package com.github.wenhao.order.gatewayimpl.remote;

import com.github.wenhao.order.gateway.remote.NotificationGateway;
import com.github.wenhao.order.model.Order;
import org.springframework.stereotype.Component;

@Component
public class NotificationGatewayImpl implements NotificationGateway {
    @Override
    public void notify(Order order) {
        return;
    }
}
