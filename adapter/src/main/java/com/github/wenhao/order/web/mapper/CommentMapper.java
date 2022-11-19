package com.github.wenhao.order.web.mapper;

import com.github.wenhao.comment.model.Comment;
import com.github.wenhao.order.web.request.CommentCreateRequest;
import com.github.wenhao.order.web.response.CommentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentMapper {

    CommentResponse toCommentResponse(Comment comment);

    List<CommentResponse> toCommentResponses(List<Comment> comments);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "orderId", source = "id"),
            @Mapping(target = "title", source = "request.title"),
            @Mapping(target = "content", source = "request.content"),
            @Mapping(target = "createdAt", expression = "java(new java.util.Date())")
    })
    Comment toComment(Long id, CommentCreateRequest request);
}
