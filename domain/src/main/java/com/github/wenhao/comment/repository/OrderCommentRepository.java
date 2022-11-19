package com.github.wenhao.comment.repository;

import com.github.wenhao.comment.model.Comment;

import java.util.List;

public interface OrderCommentRepository {
    List<Comment> findAllByOrderId(Long orderId);

    void create(Comment comment);
}
