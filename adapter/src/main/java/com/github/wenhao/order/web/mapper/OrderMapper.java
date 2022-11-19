package com.github.wenhao.order.web.mapper;

import com.github.wenhao.order.model.Order;
import com.github.wenhao.order.model.OrderItem;
import com.github.wenhao.order.web.request.OrderCreateRequest;
import com.github.wenhao.order.web.request.OrderItemCreateRequest;
import com.github.wenhao.order.web.response.OrderItemResponse;
import com.github.wenhao.order.web.response.OrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", expression = "java(new java.util.Date())")
    })
    Order toOrder(OrderCreateRequest request);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", expression = "java(new java.util.Date())")
    })
    OrderItem toOrderItem(OrderItemCreateRequest orderItemCreateRequest);

    List<OrderItemResponse> toOrderItemResponses(List<OrderItem> orderItem);

    OrderItemResponse toOrderItemResponse(OrderItem orderItem);

    List<OrderResponse> toOrderResponses(List<Order> orders);

    OrderResponse toOrderResponse(Order order);
}
