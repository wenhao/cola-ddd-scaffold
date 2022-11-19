package com.github.wenhao.order.gatewayimpl;

import com.github.wenhao.order.gateway.InventoryGateway;
import com.github.wenhao.order.model.Order;
import org.springframework.stereotype.Component;

@Component
public class InventoryGatewayImpl implements InventoryGateway {

    @Override
    public void validate(Order order) {
        return;
    }
}
