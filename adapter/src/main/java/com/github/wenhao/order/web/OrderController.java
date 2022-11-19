package com.github.wenhao.order.web;

import com.github.wenhao.order.OrderAppService;
import com.github.wenhao.order.model.Order;
import com.github.wenhao.order.web.mapper.OrderMapper;
import com.github.wenhao.order.web.request.OrderCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderAppService orderAppService;
    private final OrderMapper orderMapper;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Validated OrderCreateRequest request) {
        Order order = orderMapper.toOrder(request);
        orderAppService.create(order);
        return ResponseEntity.ok().build();
    }
}
