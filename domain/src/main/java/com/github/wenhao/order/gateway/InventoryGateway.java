package com.github.wenhao.order.gateway;

import com.github.wenhao.order.model.Order;

public interface InventoryGateway {
    void validate(Order order);
}
