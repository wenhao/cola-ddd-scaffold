package com.github.wenhao.gateway;

import com.github.wenhao.order.model.Order;

public interface NotificationGateway {
    void notify(Order order);
}
