package com.github.wenhao.order.web.mapper;

import com.github.wenhao.order.model.Order;
import com.github.wenhao.order.model.OrderItem;
import com.github.wenhao.order.web.request.OrderCreateRequest;
import com.github.wenhao.order.web.request.OrderItemCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

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
}
