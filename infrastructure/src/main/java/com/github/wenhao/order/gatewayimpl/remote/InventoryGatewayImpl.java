package com.github.wenhao.order.gatewayimpl.remote;

import com.github.wenhao.order.gateway.remote.InventoryGateway;
import com.github.wenhao.order.model.Order;
import org.springframework.stereotype.Component;

@Component
public class InventoryGatewayImpl implements InventoryGateway {

    @Override
    public void validate(Order order) {
        return;
    }
}
