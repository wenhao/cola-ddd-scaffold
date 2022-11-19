package com.github.wenhao.order.web.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class OrderItemResponse {
    private Long id;
    private String productName;
    private int quantity;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private Date createdAt;
}
