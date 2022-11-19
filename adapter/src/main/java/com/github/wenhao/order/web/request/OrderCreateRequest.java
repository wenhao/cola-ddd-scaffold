package com.github.wenhao.order.web.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class OrderCreateRequest {
    private Long customerId;
    private String orderStatus;
    private List<OrderItemCreateRequest> orderItems;
    private BigDecimal totalPrice;
}
