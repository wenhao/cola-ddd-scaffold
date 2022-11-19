package com.github.wenhao.comment.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Comment {
    private Long id;
    private Long orderId;
    private String title;
    private String content;
    private Date createdAt;
}
