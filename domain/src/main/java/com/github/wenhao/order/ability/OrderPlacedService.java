package com.github.wenhao.order.ability;

import com.github.wenhao.order.gateway.remote.InventoryGateway;
import com.github.wenhao.order.gateway.database.OrderRepository;
import com.github.wenhao.order.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderPlacedService {

    private final OrderRepository orderRepository;
    private final InventoryGateway inventoryGateway;

    public void create(Order order) {
        inventoryGateway.validate(order);
        orderRepository.add(order);
    }
}
