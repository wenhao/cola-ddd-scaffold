package com.github.wenhao.order.web;

import com.github.wenhao.order.OrderAppService;
import com.github.wenhao.comment.model.Comment;
import com.github.wenhao.order.model.Order;
import com.github.wenhao.order.web.mapper.CommentMapper;
import com.github.wenhao.order.web.mapper.OrderMapper;
import com.github.wenhao.order.web.request.CommentCreateRequest;
import com.github.wenhao.order.web.request.OrderCreateRequest;
import com.github.wenhao.order.web.response.CommentResponse;
import com.github.wenhao.order.web.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderAppService orderAppService;
    private final OrderMapper orderMapper;
    private final CommentMapper commentMapper;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Validated OrderCreateRequest request) {
        Order order = orderMapper.toOrder(request);
        orderAppService.create(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> findById(@PathVariable Long id) {
        return orderAppService.findById(id)
                .map(it -> ResponseEntity.ok(orderMapper.toOrderResponse(it)))
                .orElse(ResponseEntity.ok().build());
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<Void> cancel(@PathVariable Long id) {
        orderAppService.cancel(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/payment/{payType}")
    public ResponseEntity<Void> pay(@PathVariable Long id, @PathVariable String payType) {
        orderAppService.pay(id, payType);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<List<CommentResponse>> comments(@PathVariable Long id) {
        List<Comment> comments = orderAppService.findAllCommentByOrderId(id);
        return ResponseEntity.ok(commentMapper.toCommentResponses(comments));
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity<Void> createComment(@PathVariable Long id, @RequestBody @Validated CommentCreateRequest request) {
        Comment comment = commentMapper.toComment(id, request);
        orderAppService.createComment(comment);
        return ResponseEntity.ok().build();
    }
}
