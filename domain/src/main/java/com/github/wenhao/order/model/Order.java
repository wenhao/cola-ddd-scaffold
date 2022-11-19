package com.github.wenhao.order.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Order {
    private Long id;
    private Long customerId;
    private String orderStatus;
    private List<OrderItem> orderItems;
    private BigDecimal totalPrice;
    private Date createdAt;
}
