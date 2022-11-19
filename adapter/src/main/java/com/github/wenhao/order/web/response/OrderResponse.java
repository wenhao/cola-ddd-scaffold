package com.github.wenhao.order.web.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderResponse {
    private Long id;
    private Date CreatedAt;
    private Long customerId;
    private String orderStatus;
    private List<OrderItemResponse> orderItems;
    private BigDecimal totalPrice;
}
