package com.github.wenhao.order.gateway;

import com.github.wenhao.order.model.Order;

public interface NotificationGateway {
    void notify(Order order);
}
