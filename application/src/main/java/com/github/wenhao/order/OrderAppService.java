package com.github.wenhao.order;

import com.github.wenhao.order.ability.OrderPlacedService;
import com.github.wenhao.order.gateway.NotificationGateway;
import com.github.wenhao.order.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderAppService {
    private final OrderPlacedService orderPlacedService;
    private final NotificationGateway notificationGateway;

    public void create(Order order) {
        orderPlacedService.create(order);
        notificationGateway.notify(order);
    }
}
