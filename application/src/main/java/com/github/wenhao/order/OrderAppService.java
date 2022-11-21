package com.github.wenhao.order;

import com.github.wenhao.order.ability.OrderCommentService;
import com.github.wenhao.order.ability.OrderPlacedService;
import com.github.wenhao.order.gateway.remote.NotificationGateway;
import com.github.wenhao.order.gateway.remote.PaymentGateway;
import com.github.wenhao.comment.model.Comment;
import com.github.wenhao.order.model.Order;
import com.github.wenhao.order.gateway.database.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderAppService {
    private final OrderPlacedService orderPlacedService;
    private final NotificationGateway notificationGateway;
    private final OrderRepository orderRepository;
    private final PaymentGateway paymentGateway;
    private final OrderCommentService orderCommentService;

    public void create(Order order) {
        orderPlacedService.create(order);
        notificationGateway.notify(order);
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public void cancel(Long id) {
        orderRepository.cancel(id);
    }

    public void pay(Long id, String payType) {
        orderRepository.findById(id).ifPresent(it->paymentGateway.pay(id, payType));
    }

    public List<Comment> findAllCommentByOrderId(Long orderId){
       return orderCommentService.findAllByOrderId(orderId);
    }

    public void createComment(Comment comment) {
        orderCommentService.create(comment);
    }
}
