package com.github.wenhao.order.web.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentCreateRequest {
    private Long orderId;
    private String title;
    private String content;
}
