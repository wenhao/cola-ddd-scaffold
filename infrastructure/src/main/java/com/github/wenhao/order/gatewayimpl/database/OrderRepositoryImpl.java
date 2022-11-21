package com.github.wenhao.order.gatewayimpl.database;

import com.github.wenhao.order.gateway.database.OrderRepository;
import com.github.wenhao.order.model.Order;
import com.github.wenhao.order.model.OrderItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Optional;

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

    @Select("SELECT * FROM `t_order` WHERE id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(
                    property = "orderItems",
                    column = "id",
                    many = @Many(select = "com.github.wenhao.order.gatewayimpl.database.repository.OrderRepositoryImpl.findAllByOrderId")
            )
    })
    Optional<Order> findById(Long id);

    @Update("UPDATE t_order SET order_status='CANCELLED' WHERE id=#{id}")
    void cancel(Long id);

    @Select("SELECT * FROM order_item WHERE order_id=#{order_id}")
    List<OrderItem> findAllByOrderId(Long orderId);

    @Insert("INSERT INTO t_order(customer_id,order_status,total_price,created_at) VALUES(#{customerId}, #{orderStatus}, #{totalPrice}, #{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Long createOrder(Order order);


    @Insert("INSERT INTO order_item(order_id,product_name,quantity,price,total_price) VALUES(#{orderId},#{productName},#{quantity},#{price},#{totalPrice})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Long createOrderItem(OrderItem orderItem);
}
