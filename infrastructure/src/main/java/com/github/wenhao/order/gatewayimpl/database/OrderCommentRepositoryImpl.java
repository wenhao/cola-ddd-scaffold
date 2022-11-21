package com.github.wenhao.order.gatewayimpl.database;

import com.github.wenhao.comment.model.Comment;
import com.github.wenhao.comment.repository.OrderCommentRepository;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderCommentRepositoryImpl extends OrderCommentRepository {

    @Select("SELECT * FROM comment WHERE order_id=#{orderId}")
    List<Comment> findAllByOrderId(Long orderId);

    @Insert("INSERT INTO comment(order_id,title,content,created_at) VALUES(#{orderId},#{title},#{content},#{createdAt})")
    void create(Comment comment);
}
