package com.github.wenhao.order.gatewayimpl;

import com.github.wenhao.order.gateway.NotificationGateway;
import com.github.wenhao.order.model.Order;
import org.springframework.stereotype.Component;

@Component
public class NotificationGatewayImpl implements NotificationGateway {
    @Override
    public void notify(Order order) {
        return;
    }
}
