package com.github.wenhao.order.gateway.database;

import com.github.wenhao.order.model.Order;

import java.util.Optional;

public interface OrderRepository {
    void add(Order order);

    Optional<Order> findById(Long id);

    void cancel(Long id);
}
