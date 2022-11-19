package com.github.wenhao.order.web.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentResponse {
    private Long id;
    private Long orderId;
    private String title;
    private String content;
    private Date createdAt;
}
