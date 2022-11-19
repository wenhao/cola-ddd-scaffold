package com.github.wenhao.order.ability;

import com.github.wenhao.comment.model.Comment;
import com.github.wenhao.comment.repository.OrderCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderCommentService {

    private final OrderCommentRepository orderCommentRepository;

    public List<Comment> findAllByOrderId(Long orderId) {
        return orderCommentRepository.findAllByOrderId(orderId);
    }

    public void create(Comment comment) {
        orderCommentRepository.create(comment);
    }
}
