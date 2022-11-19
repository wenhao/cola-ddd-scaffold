package com.github.wenhao.order.web.mapper;

import com.github.wenhao.order.model.Order;
import com.github.wenhao.order.model.OrderItem;
import com.github.wenhao.order.repository.OrderRepository;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface OrderRepositoryImpl extends OrderRepository {

    @Override
    default void add(Order order) {
        Long orderId = createOrder(order);
        for (OrderItem orderItem : order.getOrderItems()) {
            orderItem.setOrderId(orderId);
            createOrderItem(orderItem);
        }
    }

    @Insert("INSERT INTO t_order(customer_id,order_status,total_price,created_at) VALUES(#{customerId}, #{orderStatus}, #{totalPrice}, #{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Long createOrder(Order order);


    @Insert("INSERT INTO order_item(order_id,product_name,quantity,price,total_price) VALUES(#{orderId},#{productName},#{quantity},#{price},#{totalPrice})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Long createOrderItem(OrderItem orderItem);
}
